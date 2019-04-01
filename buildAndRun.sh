#!/bin/sh
mvn clean package && docker build -t markolazic/learninglog .
docker rm -f learninglog || true && docker run -d -p 8080:8080 -p 4848:4848 --name learninglog markolazic/learninglog
