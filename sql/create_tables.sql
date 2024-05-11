START TRANSACTION;

DROP TABLE IF EXISTS location_and_time CASCADE;
DROP TABLE IF EXISTS weather_conditions CASCADE;
DROP TABLE IF EXISTS air_quality CASCADE;

CREATE TABLE location_and_time (
    location_id SERIAL PRIMARY KEY,
    country VARCHAR(100),
    location_name VARCHAR(100),
    region VARCHAR(100),
    latitude NUMERIC,
    longitude NUMERIC,
    timezone VARCHAR(50),
    last_updated_epoch BIGINT,
    last_updated TIMESTAMP
);

CREATE TABLE weather_conditions (
    location_id INT,
    temperature_celsius NUMERIC,
    temperature_fahrenheit NUMERIC,
    condition_text VARCHAR(255),
    wind_mph NUMERIC,
    wind_kph NUMERIC,
    wind_degree INT,
    wind_direction VARCHAR(50),
    pressure_mb NUMERIC,
    pressure_in NUMERIC,
    precip_mm NUMERIC,
    precip_in NUMERIC,
    humidity INT,
    cloud INT,
    feels_like_celsius NUMERIC,
    feels_like_fahrenheit NUMERIC,
    visibility_km NUMERIC,
    visibility_miles NUMERIC,
    uv_index NUMERIC,
    gust_mph NUMERIC,
    gust_kph NUMERIC,
    sunrise TIME,
    sunset TIME,
    moonrise VARCHAR(50),
    moonset VARCHAR(50),
    moon_phase VARCHAR(50),
    moon_illumination INT,
    FOREIGN KEY (location_id) REFERENCES location_and_time(location_id)
);

CREATE TABLE air_quality (
    location_id INT,
    air_quality_Carbon_Monoxide NUMERIC,
    air_quality_Ozone NUMERIC,
    air_quality_Nitrogen_dioxide NUMERIC,
    air_quality_Sulphur_dioxide NUMERIC,
    air_quality_PM2_5 NUMERIC,
    air_quality_PM10 NUMERIC,
    air_quality_us_epa_index INT,
    air_quality_gb_defra_index INT,
    FOREIGN KEY (location_id) REFERENCES location_and_time(location_id)
);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_temperature_celsius;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_temperature_celsius CHECK (temperature_celsius >= -50 AND temperature_celsius <= 50);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_temperature_fahrenheit;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_temperature_fahrenheit CHECK (temperature_fahrenheit >= -58 AND temperature_fahrenheit <= 122);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_humidity;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_humidity CHECK (humidity >= 0 AND humidity <= 100);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_cloud;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_cloud CHECK (cloud >= 0 AND cloud <= 100);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_uv_index;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_uv_index CHECK (uv_index >= 0 AND uv_index <= 11);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_wind_mph;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_wind_mph CHECK (wind_mph >= 0);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_wind_kph;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_wind_kph CHECK (wind_kph >= 0);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_gust_mph;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_gust_mph CHECK (gust_mph >= 0);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_gust_kph;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_gust_kph CHECK (gust_kph >= 0);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_precip_mm;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_precip_mm CHECK (precip_mm >= 0);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_precip_in;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_precip_in CHECK (precip_in >= 0);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_visibility_km;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_visibility_km CHECK (visibility_km >= 0);

ALTER TABLE weather_conditions DROP CONSTRAINT IF EXISTS ck_visibility_miles;
ALTER TABLE weather_conditions ADD CONSTRAINT ck_visibility_miles CHECK (visibility_miles >= 0);

COMMIT;