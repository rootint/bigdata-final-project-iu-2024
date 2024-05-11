SHOW DATABASES;

DROP DATABASE IF EXISTS team17_projectdb CASCADE;

CREATE DATABASE team17_projectdb LOCATION "project/hive/warehouse";
USE team17_projectdb;
CREATE EXTERNAL TABLE weather STORED AS AVRO LOCATION 'project/warehouse/weather' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/weather.avsc');

DESCRIBE FORMATTED weather;

SELECT * FROM weather LIMIT 10;

CREATE EXTERNAL TABLE weather_regions (
  country string,
  location_name string,
  latitude double,
  longitude double,
  timezone string,
  last_updated_epoch bigint,
  last_updated bigint,
  temperature_celsius double,
  temperature_fahrenheit double,
  condition_text string,
  wind_mph double,
  wind_kph double,
  wind_degree int,
  wind_direction string,
  pressure_mb double,
  pressure_in double,
  precip_mm double,
  precip_in double,
  humidity int,
  cloud int,
  feels_like_celsius double,
  feels_like_fahrenheit double,
  visibility_km double,
  visibility_miles double,
  uv_index double,
  gust_mph double,
  gust_kph double,
  air_quality_carbon_monoxide double,
  air_quality_ozone double,
  air_quality_nitrogen_dioxide double,
  air_quality_sulphur_dioxide double,
  air_quality_pm2_5 double,
  air_quality_pm10 double,
  air_quality_us_epa_index int,
  air_quality_gb_defra_index int,
  sunrise string,
  sunset string,
  moonrise string,
  moonset string,
  moon_phase string,
  moon_illumination int
)
PARTITIONED BY (region string)
CLUSTERED BY (location_name) INTO 10 BUCKETS
STORED AS AVRO 
LOCATION 'project/hive/warehouse/weather_regions'
TBLPROPERTIES ('avro.compress' = 'SNAPPY');

INSERT INTO weather_regions 
SELECT
  CAST(country AS string),
  CAST(location_name AS string),
  CAST(latitude AS double),
  CAST(longitude AS double),
  CAST(timezone AS string),
  last_updated_epoch,
  last_updated,
  CAST(temperature_celsius AS double),
  CAST(temperature_fahrenheit AS double),
  CAST(condition_text AS string),
  CAST(wind_mph AS double),
  CAST(wind_kph AS double),
  wind_degree,
  CAST(wind_direction AS string),
  CAST(pressure_mb AS double),
  CAST(pressure_in AS double),
  CAST(precip_mm AS double),
  CAST(precip_in AS double),
  humidity,
  cloud,
  CAST(feels_like_celsius AS double),
  CAST(feels_like_fahrenheit AS double),
  CAST(visibility_km AS double),
  CAST(visibility_miles AS double),
  CAST(uv_index AS double),
  CAST(gust_mph AS double),
  CAST(gust_kph AS double),
  CAST(air_quality_carbon_monoxide AS double),
  CAST(air_quality_ozone AS double),
  CAST(air_quality_nitrogen_dioxide AS double),
  CAST(air_quality_sulphur_dioxide AS double),
  CAST(air_quality_pm2_5 AS double),
  CAST(air_quality_pm10 AS double),
  air_quality_us_epa_index,
  air_quality_gb_defra_index,
  CAST(sunrise AS string),
  CAST(sunset AS string),
  CAST(moonrise AS string),
  CAST(moonset AS string),
  CAST(moon_phase AS string),
  moon_illumination,
  region 
FROM weather;

DROP TABLE IF EXISTS weather;