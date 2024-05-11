#!/bin/bash
password=$(head -n 1 .env)

echo "Loading data into PostgreSQL"
python3 scripts/build_projectdb.py

echo "Importing data to HDFS and compressing..."
hdfs dfs -rm -r -f project
sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team17_projectdb --username team17 --password $password --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=project/warehouse --m 1

echo "Copying files..."
rm output/location_and_time.avsc
rm output/location_and_time.java
rm output/weather_conditions.avsc
rm output/weather_conditions.java
rm output/air_quality.avsc
rm output/air_quality.java
mv location_and_time.avsc output
mv location_and_time.java output
mv weather_conditions.avsc output
mv weather_conditions.java output
mv air_quality.avsc output
mv air_quality.java output

echo "Running pylint..."
pylint scripts/build_projectdb.py

echo "Stage 1 complete!"