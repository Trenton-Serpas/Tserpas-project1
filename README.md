# Project1 wikipedia viewcount
This project takes data files from wikipedia of how many views each page has as retrievable here https://dumps.wikimedia.org/other/pageviews/

It then combines the views from each country and discards any pieces with less than 100 views

## Technologies Used

* Hive
* Big-Data-Europe's Hive docker container - https://github.com/big-data-europe/docker-hadoop
* More in 1st part at the link at the bottom of this README

## Features

* Combine the the count of views from each region
* Discards any pages with less than 100 views
* Store the results in an easy to retrieve format

To-do list:
* Implement a Easy to understand script that can be ran for the below lines

## How to run
Set up Big Data Europes hive container
```bash
git clone https://github.com/big-data-europe/docker-hive && cd docker-hive
docker-compose up -d
```

copy your previous data to the namenode container then access it and prepare the data
```bash
docker cp {YOUR HADOOP NAMENODE CONTAINER ID}:output output
docker exec -it {YOUR docker-hive_namenode} bash
hadoop fs -get output output
```

Now you can leave the namenode container and run
```bash
sbt run
```

## See Hadoop Data processing part of this project!
https://github.com/Trenton-Serpas/Tserpas-project1-hadoop
