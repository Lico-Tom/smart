#!/bin/bash

docker network create dockerbetweenweennetwork

docker run -d --name mysql --network=dockerbetweennetwork -e MYSQL_ROOT_PASSWORD=root mysql:latest

docker run -d --name smart-home -p9091:9091 --network=dockerbetweennetwork -e DATABASE_NAME=smart_home -e MYSQL_POD_NAME=mysql-pro -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 -e MYSQL_USER=root 52ada110b605
