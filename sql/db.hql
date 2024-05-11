DROP DATABASE IF EXISTS team17_projectdb CASCADE;
CREATE DATABASE team17_projectdb LOCATION "project/hive/warehouse";
USE team17_projectdb;

CREATE EXTERNAL TABLE location_and_time STORED AS AVRO LOCATION 'project/warehouse/location_and_time' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/location_and_time.avsc');
CREATE EXTERNAL TABLE weather_conditions STORED AS AVRO LOCATION 'project/warehouse/weather_conditions' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/weather_conditions.avsc');
CREATE EXTERNAL TABLE air_quality STORED AS AVRO LOCATION 'project/warehouse/air_quality' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/air_quality.avsc');

DESCRIBE FORMATTED location_and_time;
DESCRIBE FORMATTED weather_conditions;
DESCRIBE FORMATTED air_quality;

CREATE EXTERNAL TABLE location_and_time_region (
    location_id INT,
    country STRING,
    location_name STRING,
    latitude DOUBLE,
    longitude DOUBLE,
    timezone STRING,
    last_updated_epoch BIGINT,
    last_updated TIMESTAMP
)
PARTITIONED BY (region STRING)
CLUSTERED BY (location_id) INTO 4 BUCKETS
STORED AS AVRO
LOCATION 'project/hive/warehouse/location_and_time_region'
TBLPROPERTIES ('avro.compress' = 'SNAPPY');

CREATE EXTERNAL TABLE weather_conditions_updated (
    location_id INT,
    temperature_celsius STRING,
    temperature_fahrenheit STRING,
    wind_mph STRING,
    wind_kph STRING,
    wind_degree INT,
    wind_direction STRING,
    pressure_mb STRING,
    pressure_in STRING,
    precip_mm STRING,
    precip_in STRING,
    humidity INT,
    cloud INT,
    feels_like_celsius STRING,
    feels_like_fahrenheit STRING,
    visibility_km STRING,
    visibility_miles STRING,
    uv_index STRING,
    gust_mph STRING,
    gust_kph STRING,
    sunrise STRING,
    sunset STRING,
    moonrise STRING,
    moonset STRING,
    moon_phase STRING,
    moon_illumination INT
)
PARTITIONED BY (condition_text STRING)
CLUSTERED BY (location_id) INTO 4 BUCKETS
STORED AS AVRO
LOCATION 'project/hive/warehouse/weather_conditions_updated'
TBLPROPERTIES ('avro.compress' = 'SNAPPY');

CREATE EXTERNAL TABLE air_quality_region (
    location_id INT,
    air_quality_Carbon_Monoxide DOUBLE,
    air_quality_Ozone DOUBLE,
    air_quality_Nitrogen_dioxide DOUBLE,
    air_quality_Sulphur_dioxide DOUBLE,
    air_quality_PM2_5 DOUBLE,
    air_quality_PM10 DOUBLE,
    air_quality_gb_defra_index INT
)
PARTITIONED BY (air_quality_us_epa_index INT)
CLUSTERED BY (location_id) INTO 4 BUCKETS
STORED AS AVRO
LOCATION 'project/hive/warehouse/air_quality_region'
TBLPROPERTIES ('avro.compress' = 'SNAPPY');

SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;

INSERT INTO TABLE location_and_time_region
PARTITION(region)
SELECT
    location_id,      
    country,
    location_name,
    CAST(latitude AS DOUBLE),
    CAST(longitude AS DOUBLE),
    timezone,
    last_updated_epoch,
    last_updated,
    region              
FROM location_and_time;

INSERT INTO TABLE air_quality_region
PARTITION(air_quality_us_epa_index)
SELECT
    location_id,
    CAST(air_quality_carbon_monoxide AS double),
    CAST(air_quality_ozone AS double),
    CAST(air_quality_nitrogen_dioxide AS double),
    CAST(air_quality_sulphur_dioxide AS double),
    CAST(air_quality_pm2_5 AS double),
    CAST(air_quality_pm10 AS double),
    air_quality_gb_defra_index,
    air_quality_us_epa_index
FROM air_quality;

INSERT INTO TABLE weather_conditions_updated
PARTITION(condition_text)
SELECT
    location_id,
    temperature_celsius,
    temperature_fahrenheit,
    wind_mph,
    wind_kph,
    wind_degree,
    wind_direction,
    pressure_mb,
    pressure_in,
    precip_mm,
    precip_in,
    humidity,
    cloud,
    feels_like_celsius,
    feels_like_fahrenheit,
    visibility_km,
    visibility_miles,
    uv_index,
    gust_mph,
    gust_kph,
    sunrise,
    sunset,
    moonrise,
    moonset,
    moon_phase,
    moon_illumination,
    condition_text
FROM weather_conditions;

DROP TABLE IF EXISTS location_and_time;
DROP TABLE IF EXISTS air_quality;
DROP TABLE IF EXISTS weather_conditions;