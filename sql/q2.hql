USE team17_projectdb;

DROP TABLE IF EXISTS q2_results;

CREATE EXTERNAL TABLE q2_results (
    temperature_celsius FLOAT,
    air_quality_PM2_5 FLOAT)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q2';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q2_results
SELECT wc.temperature_celsius, aq.air_quality_PM2_5
FROM weather_conditions_updated wc
JOIN air_quality_region aq ON wc.location_id = aq.location_id;

INSERT OVERWRITE DIRECTORY 'project/output/q2' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 

SELECT * FROM q2_results;