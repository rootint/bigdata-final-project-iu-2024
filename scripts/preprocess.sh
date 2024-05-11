#!/bin/bash
password=$(head -n 1 .env)

# I copied the dataset from kaggle not to share the kaggle key on the repo
# and the dataset changes frequently (a new data is added), so that taking a copy makes sense.
# The dataset was downloaded from kaggle on 05.05.2024
# Dataset link: https://www.kaggle.com/datasets/nelgiriyewithana/indian-weather-repository-daily-snapshot?select=IndianWeatherRepository.csv
echo "Downloading data..."
url="https://storage.yandexcloud.net/openbucket/IndianWeatherRepo.zip"
curl $url -o data/data.zip

echo "Unzipping..."
unzip data/data.zip -d data/
cp data/IndianWeatherRepository/*.csv data/sandbox/
cp data/IndianWeatherRepository/*.csv data
rm data/data.zip
rm -rf data/IndianWeatherRepository
rm -rf data/__MACOSX