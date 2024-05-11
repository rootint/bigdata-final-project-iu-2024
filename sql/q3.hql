USE team17_projectdb;

DROP TABLE IF EXISTS q3_results;

SELECT
    w.wind_mph,
    a.air_quality_PM2_5
FROM
    weather_conditions_updated w
JOIN
    air_quality_region a ON w.location_id = a.location_id;

CREATE EXTERNAL TABLE q3_results (
    wind_mph DOUBLE,
    air_quality_PM2_5 DOUBLE
)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q3';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q3_results
SELECT
    CAST(w.wind_mph AS DOUBLE),
    CAST(a.air_quality_PM2_5 AS DOUBLE)
FROM
    weather_conditions_updated w
JOIN
    air_quality_region a ON w.location_id = a.location_id;

INSERT OVERWRITE DIRECTORY 'project/output/q3' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 

SELECT * FROM q3_results;