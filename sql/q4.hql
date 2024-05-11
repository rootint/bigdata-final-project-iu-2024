USE team17_projectdb;

SELECT
    l.region,
    a.air_quality_PM2_5
FROM
    location_and_time_region l
JOIN
    air_quality_region a ON l.location_id = a.location_id
GROUP BY
    l.region, a.air_quality_PM2_5;

DROP TABLE IF EXISTS q4_results;
CREATE EXTERNAL TABLE q4_results (
    region STRING,
    average_pm25 FLOAT,
    max_pm25 FLOAT,
    min_pm25 FLOAT,
    stddev_pm25 FLOAT)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ',' 
LOCATION 'project/hive/warehouse/q4';

SET hive.resultset.use.unique.column.names = false;

INSERT INTO q4_results
SELECT 
    l.region,
    AVG(a.air_quality_PM2_5) AS avg_pm25, 
    MAX(a.air_quality_PM2_5) AS max_pm25, 
    MIN(a.air_quality_PM2_5) AS min_pm25, 
    STDDEV(a.air_quality_PM2_5) AS stddev_pm25
FROM
    location_and_time_region l
JOIN
    air_quality_region a ON l.location_id = a.location_id
GROUP BY
    l.region;

INSERT OVERWRITE DIRECTORY 'project/output/q4' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 

SELECT * FROM q4_results;