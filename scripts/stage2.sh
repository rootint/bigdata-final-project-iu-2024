#!/bin/bash
password=$(head -n 1 .env)

echo "Copying files..."
hdfs dfs -rm -r -f project/warehouse/avsc
hdfs dfs -rm -r -f project/hive
hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put output/*.avsc project/warehouse/avsc

echo "Creating external, partitioned and bucketing Hive tables..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team17 -p $password -f sql/db.hql > output/hive_results.txt 2> /dev/null

echo "q1 experiment: "
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team17 -p $password -f sql/q1.hql
hdfs dfs -cat project/output/q1/* > output/q1.csv
echo "q2 experiment: "
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team17 -p $password -f sql/q2.hql
hdfs dfs -cat project/output/q2/* > output/q2.csv
echo "q3 experiment: "
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team17 -p $password -f sql/q3.hql
hdfs dfs -cat project/output/q3/* > output/q3.csv
echo "q4 experiment: "
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team17 -p $password -f sql/q4.hql
hdfs dfs -cat project/output/q4/* > output/q4.csv
echo "q5 experiment: "
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team17 -p $password -f sql/q5.hql
hdfs dfs -cat project/output/q5/* > output/q5.csv

echo "No python scripts were used, skipping pylint..."

echo "Stage 2 complete!"