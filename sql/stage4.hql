USE team17_projectdb;

DROP TABLE IF EXISTS evaluation;

CREATE EXTERNAL TABLE evaluation (
    model STRING, 
    r2 float, 
    rmse float) 
row format SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
tblproperties ("skip.header.line.count"="1");

load data inpath '../team17/output/evaluation/evaluation.csv' overwrite into table evaluation;

DROP TABLE IF EXISTS model1_results;

CREATE EXTERNAL TABLE model1_results (
    air_quality float, 
    prediction float) 
row format SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
tblproperties ("skip.header.line.count"="1");

load data inpath '../team17/project/output/model1_predictions.csv' overwrite into table model1_results;

DROP TABLE IF EXISTS model2_results;

CREATE EXTERNAL TABLE model2_results (
    air_quality float, 
    prediction float) 
row format SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
tblproperties ("skip.header.line.count"="1");

load data inpath '../team17/project/output/model2_predictions.csv' overwrite into table model2_results;