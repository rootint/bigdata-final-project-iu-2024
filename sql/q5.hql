USE team17_projectdb;

DROP TABLE IF EXISTS q5_results;

CREATE EXTERNAL TABLE q5_results (
    pressure_mb FLOAT,
    air_quality_PM2_5 FLOAT)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q5';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q5_results
SELECT wc.pressure_mb, aq.air_quality_PM2_5
FROM weather_conditions_updated wc
JOIN air_quality_region aq ON wc.location_id = aq.location_id;

INSERT OVERWRITE DIRECTORY 'project/output/q5' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 

SELECT * FROM q5_results;