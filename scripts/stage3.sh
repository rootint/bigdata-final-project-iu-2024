#!/bin/bash
password=$(head -n 1 .env)

echo "Training models..."
spark-submit --master yarn scripts/model_training.py 

echo "Copying data..."
hdfs dfs -cat project/data/train/*.json > data/train.json
hdfs dfs -cat project/data/test/*.json > data/test.json

echo "Copying models..."
hdfs dfs -get -f project/models/model1 models
hdfs dfs -get -f project/models/model2 models

echo "Copying predictions..."
hdfs dfs -cat project/output/model1_predictions.csv/*.csv > output/model1_predictions.csv
hdfs dfs -cat project/output/model2_predictions.csv/*.csv > output/model2_predictions.csv

hdfs dfs -cat output/evaluation/evaluation.csv/*.csv > output/evaluation.csv

echo "Running pylint..."
pylint scripts/model_training.py

echo "Stage 3 complete!"