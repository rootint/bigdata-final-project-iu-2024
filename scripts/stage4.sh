#!/bin/bash
password=$(head -n 1 .env)

echo "Creating dashboard tables..."
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team17 -p $password -f sql/stage4.hql