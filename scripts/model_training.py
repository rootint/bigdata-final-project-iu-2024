"""
    The script that trains the model.
"""
import math

import numpy as np
from pyspark.sql import SparkSession, Row
from pyspark.sql.functions import year, month, dayofmonth, hour, minute, sin, cos, col
from pyspark.ml.param import Param, Params
from pyspark.ml import Transformer, Pipeline
from pyspark.ml.feature import (
    VectorAssembler,
    StandardScaler,
    StringIndexer,
    OneHotEncoder,
)
from pyspark.ml.util import DefaultParamsReadable, DefaultParamsWritable
from pyspark.ml.regression import RandomForestRegressor, GBTRegressor
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pyspark.ml.evaluation import RegressionEvaluator


class LatLonToECEF(Transformer, DefaultParamsReadable, DefaultParamsWritable):
    """
        Handles conversion to x, y, z from lat / lon.
    """

    def _transform(self, dataset):
        # Earth's radius is approximately 6371 km
        radius = 6371
        dataset = dataset.withColumn(
            "x",
            radius
            * cos(col("latitude") * np.pi / 180)
            * cos(col("longitude") * np.pi / 180),
        )
        dataset = dataset.withColumn(
            "y",
            radius
            * cos(col("latitude") * np.pi / 180)
            * sin(col("longitude") * np.pi / 180),
        )
        dataset = dataset.withColumn("z", radius * sin(col("latitude") * np.pi / 180))
        return dataset


class SinCosEncoder(Transformer, Params):
    """
        Converts time into sin/cos lines.
    """
    inputCol = Param(Params._dummy(), "inputCol", "input column name")
    outputCols = Param(Params._dummy(), "outputCols", "output column names")

    def __init__(self, inputCol, outputCols):
        super().__init__()
        self._setDefault(inputCol=inputCol, outputCols=outputCols)

    def get_input_col(self):
        """
            Returns self.getOrDefault(self.inputCol).
        """
        return self.getOrDefault(self.inputCol)

    def get_output_cols(self):
        """
            Returns self.getOrDefault(self.outputCols).
        """
        return self.getOrDefault(self.outputCols)

    def _transform(self, dataset):
        input_col = self.get_input_col()
        output_cols = self.get_output_cols()
        sin_col = f"{output_cols[0]}"
        cos_col = f"{output_cols[1]}"

        dataset = dataset.withColumn(sin_col, sin(2 * math.pi * col(input_col) / 12))
        dataset = dataset.withColumn(cos_col, cos(2 * math.pi * col(input_col) / 12))
        return dataset


class MonthEncoder(SinCosEncoder):
    """
        Converts months into sin/cos lines.
    """
    def __init__(self, inputCol="month", outputCols=None):
        if outputCols is None:
            outputCols = ["monthsin", "monthcos"]
        super().__init__(inputCol, outputCols)


class DayEncoder(SinCosEncoder):
    """
        Converts days into sin/cos lines.
    """
    def __init__(self, inputCol="day", outputCols=None):
        if outputCols is None:
            outputCols = ["daysin", "daycos"]
        super().__init__(inputCol, outputCols)


class HourEncoder(SinCosEncoder):
    """
        Converts hours into sin/cos lines.
    """
    def __init__(self, inputCol="hour", outputCols=None):
        if outputCols is None:
            outputCols = ["hoursin", "hourcos"]
        super().__init__(inputCol, outputCols)


class MinuteEncoder(SinCosEncoder):
    """
        Converts minutes into sin/cos lines.
    """
    def __init__(self, inputCol="minute", outputCols=None):
        if outputCols is None:
            outputCols = ["minutesin", "minutecos"]
        super().__init__(inputCol, outputCols)


def train_rf(train_data, test_data, label_col):
    """
        A function that picks the best hyperparameters for a RF and saves the model.
    """
    rf_tuned = RandomForestRegressor(featuresCol="scaled_features", labelCol=label_col)

    # Define the grid of hyperparameters to test:
    #  - numTrees: number of trees in the forest.
    #  - maxDepth: maximum depth of each tree.
    rf_param_grid = (
        ParamGridBuilder()
        .addGrid(rf_tuned.numTrees, [20, 30])
        .addGrid(rf_tuned.maxDepth, [5, 10])
        .build()
    )

    # Setup evaluation metric
    rf_tuned_evaluator = RegressionEvaluator(
        labelCol=label_col, predictionCol="prediction"
    )

    # Cross-validator
    rf_cv = CrossValidator(
        estimator=rf_tuned,
        estimatorParamMaps=rf_param_grid,
        evaluator=rf_tuned_evaluator,
        numFolds=3,
    )

    # Fit the model
    rf_cv_model = rf_cv.fit(train_data)

    # Choose the best model
    rf_best_model = rf_cv_model.bestModel

    # Save the best model
    rf_best_model.write().overwrite().save("project/models/model1")

    best_params = rf_best_model.extractParamMap()
    for param, value in best_params.items():
        if param.name in ("numTrees", "maxDepth"):
            print(f"{param.name}: {value}")

    # Evaluation on the test set
    rf_tuned_predictions = rf_best_model.transform(test_data)
    rf_tuned_predictions.select(label_col, "prediction").coalesce(1).write.mode(
        "overwrite"
    ).option("header", "true").csv("project/output/model1_predictions.csv")

    # Evaluate the best model and print out the result
    rf_tuned_r2 = rf_tuned_evaluator.evaluate(
        rf_tuned_predictions, {rf_tuned_evaluator.metricName: "r2"}
    )
    rf_tuned_rmse = rf_tuned_evaluator.evaluate(
        rf_tuned_predictions, {rf_tuned_evaluator.metricName: "rmse"}
    )
    print("Test R^2: ", rf_tuned_r2)
    print("Test RMSE: ", rf_tuned_rmse)

    return rf_tuned_r2, rf_tuned_rmse


def train_gbt(train_data, test_data, label_col):
    """
        A function that picks the best hyperparameters for a GBT and saves the model.
    """
    gbt_tuned = GBTRegressor(featuresCol="scaled_features", labelCol=label_col)

    gbt_tuned_evaluator = RegressionEvaluator(
        labelCol=label_col, predictionCol="prediction"
    )

    # Define the parameter grid for tuning
    gbt_param_grid = (
        ParamGridBuilder()
        .addGrid(gbt_tuned.maxDepth, [3, 5])
        .addGrid(gbt_tuned.maxIter, [10, 20])
        .build()
    )

    # Setup CrossValidator for model tuning
    gbt_crossval = CrossValidator(
        estimator=gbt_tuned,
        estimatorParamMaps=gbt_param_grid,
        evaluator=gbt_tuned_evaluator,
        numFolds=3,
    )  # Use 3+ folds in practice

    # Fit the model
    gbt_cv_model = gbt_crossval.fit(train_data)

    gbt_best_model = gbt_cv_model.bestModel
    gbt_best_model.write().overwrite().save("project/models/model2")

    gbt_best_params = gbt_best_model.extractParamMap()
    for param, value in gbt_best_params.items():
        if param.name in ("maxIter", "maxDepth"):
            print(f"{param.name}: {value}")

    # Evaluation on the test set
    gbt_tuned_predictions = gbt_best_model.transform(test_data)
    gbt_tuned_predictions.select(label_col, "prediction").coalesce(1).write.mode(
        "overwrite"
    ).option("header", "true").csv("project/output/model2_predictions.csv")

    # Evaluate the best model and print out the result
    gbt_tuned_r2 = gbt_tuned_evaluator.evaluate(
        gbt_tuned_predictions, {gbt_tuned_evaluator.metricName: "r2"}
    )
    gbt_tuned_rmse = gbt_tuned_evaluator.evaluate(
        gbt_tuned_predictions, {gbt_tuned_evaluator.metricName: "rmse"}
    )
    print("Test R^2: ", gbt_tuned_r2)
    print("Test RMSE: ", gbt_tuned_rmse)

    return gbt_tuned_r2, gbt_tuned_rmse


def main():
    """
        The function where everything is executed.
    """

    spark = (
        SparkSession.builder.appName("team17 - spark ML")
        .master("yarn")
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")
        .config("spark.sql.warehouse.dir", "project/hive/warehouse")
        .config("spark.executor.instances", 5)
        .config("spark.sql.avro.compression.codec", "snappy")
        .enableHiveSupport()
        .getOrCreate()
    )

    weather = spark.read.format("avro").table(
        "team17_projectdb.weather_conditions_updated"
    )
    air_quality = spark.read.format("avro").table("team17_projectdb.air_quality_region")
    location_and_time = spark.read.format("avro").table(
        "team17_projectdb.location_and_time_region"
    )

    location_and_time = location_and_time.select(
        "*",
        year("last_updated").alias("year"),
        month("last_updated").alias("month"),
        dayofmonth("last_updated").alias("day"),
        hour("last_updated").alias("hour"),
        minute("last_updated").alias("minute"),
    )

    weather = (
        weather.withColumn(
            "temperature_celsius", col("temperature_celsius").cast("double")
        )
        .withColumn(
            "temperature_fahrenheit", col("temperature_fahrenheit").cast("double")
        )
        .withColumn("wind_mph", col("wind_mph").cast("double"))
        .withColumn("wind_kph", col("wind_kph").cast("double"))
        .withColumn("pressure_mb", col("pressure_mb").cast("double"))
        .withColumn("pressure_in", col("pressure_in").cast("double"))
        .withColumn("precip_mm", col("precip_mm").cast("double"))
        .withColumn("precip_in", col("precip_in").cast("double"))
        .withColumn("feels_like_celsius", col("feels_like_celsius").cast("double"))
        .withColumn(
            "feels_like_fahrenheit", col("feels_like_fahrenheit").cast("double")
        )
        .withColumn("visibility_km", col("visibility_km").cast("double"))
        .withColumn("visibility_miles", col("visibility_miles").cast("double"))
        .withColumn("uv_index", col("uv_index").cast("double"))
        .withColumn("gust_kph", col("gust_kph").cast("double"))
        .withColumn("gust_mph", col("gust_mph").cast("double"))
    )

    month_encoder = MonthEncoder()
    day_encoder = DayEncoder()
    hour_encoder = HourEncoder()
    minute_encoder = MinuteEncoder()
    ecef_encoder = LatLonToECEF()

    data = weather.join(air_quality, on="location_id", how="inner")
    data = data.join(location_and_time, on="location_id", how="inner")

    feature_cols = [
        "x",
        "y",
        "z",  # ECEF coordinates
        "monthsin",
        "monthcos",
        "daysin",
        "daycos",
        "hoursin",
        "hourcos",
        "minutesin",
        "minutecos",  # time encodings
        "temperature_celsius",
        "humidity",
        "wind_kph",
        "pressure_mb",
        "precip_mm",
        "cloud",
        "feels_like_celsius",
        "visibility_km",
        "uv_index",
        "gust_kph",
        "wind_degree",
        "moon_illumination",
    ]

    # Convert text categories to indices
    condition_indexer = StringIndexer(
        inputCol="condition_text", outputCol="condition_index"
    )
    # Convert indices to one-hot encoded variables
    condition_encoder = OneHotEncoder(
        inputCols=["condition_index"], outputCols=["condition_encoded"]
    )

    assembler = VectorAssembler(
        inputCols=feature_cols + ["condition_encoded"], outputCol="features"
    )
    scaler = StandardScaler(inputCol="features", outputCol="scaled_features")

    # Select one or more air quality measures as labels depending on your analysis approach
    label_col = "air_quality_us_epa_index"

    pipeline = Pipeline(
        stages=[
            month_encoder,
            day_encoder,
            hour_encoder,
            minute_encoder,
            ecef_encoder,
            condition_indexer,
            condition_encoder,
            assembler,
            scaler,
        ]
    )
    model = pipeline.fit(data)
    transformed_data = model.transform(data)

    train_data, test_data = transformed_data.randomSplit([0.7, 0.3], seed=42)
    train_data.write.mode("overwrite").json("project/data/train")
    test_data.write.mode("overwrite").json("project/data/test")

    print('Training RF...')
    rf_base = RandomForestRegressor(featuresCol="scaled_features", labelCol=label_col)
    rf_evaluator = RegressionEvaluator(labelCol=label_col, predictionCol="prediction")
    rf_base_model = rf_base.fit(train_data)
    predictions = rf_base_model.transform(test_data)
    rf_base_r2 = rf_evaluator.evaluate(predictions, {rf_evaluator.metricName: "r2"})
    rf_base_rmse = rf_evaluator.evaluate(predictions, {rf_evaluator.metricName: "rmse"})
    print("Test R^2: ", rf_base_r2)
    print("Test RMSE: ", rf_base_rmse)

    print('Training RF Tuned...')
    rf_tuned_r2, rf_tuned_rmse = train_rf(
        train_data=train_data, test_data=test_data, label_col=label_col
    )

    print('Training GBT...')
    gbt_base = GBTRegressor(featuresCol="scaled_features", labelCol=label_col)

    gbt_evaluator = RegressionEvaluator(labelCol=label_col, predictionCol="prediction")

    # Fit the model
    gbt_base_model = gbt_base.fit(train_data)

    # Evaluation on the test set
    gbt_base_predictions = gbt_base_model.transform(test_data)

    # Evaluate the best model and print out the result
    gbt_base_r2 = gbt_evaluator.evaluate(
        gbt_base_predictions, {gbt_evaluator.metricName: "r2"}
    )
    gbt_base_rmse = gbt_evaluator.evaluate(
        gbt_base_predictions, {gbt_evaluator.metricName: "rmse"}
    )
    print("Test R^2: ", gbt_base_r2)
    print("Test RMSE: ", gbt_base_rmse)

    print('Training GBT Tuned...')
    gbt_tuned_r2, gbt_tuned_rmse = train_gbt(
        train_data=train_data, test_data=test_data, label_col=label_col
    )

    evaluation_data = [
        Row(
            model_name="RandomForestRegressor",
            r2_metric=rf_tuned_r2,
            rmse_metric=rf_tuned_rmse,
        ),
        Row(
            model_name="GBTRegressor",
            r2_metric=gbt_tuned_r2,
            rmse_metric=gbt_tuned_rmse,
        ),
    ]
    evaluation_df = spark.createDataFrame(evaluation_data)

    evaluation_df.show()

    evaluation_df.coalesce(1).write.mode("overwrite").option("header", "true").csv(
        "output/evaluation/evaluation.csv"
    )


if __name__ == "__main__":
    main()
