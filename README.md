# ORACLE DOCKER
    docker run -d -it -p 1521:1521 -p 5500:5500 --name oracle -e DB_SERVICE=ORCLPDB1 store/oracle/database-enterprise:12.2.0.1-slim
    
ORACLE_SID default value is ORCLCDB
The default password to connect to the database with sys user is Oradoc_db1
    
To Create pluggable database

    create user C##LEARNINGLOG identified by LEARNINGLOG container=all ;
    
    GRANT CREATE SESSION, SYSOPER,PDB_DBA,DBA, CREATE PLUGGABLE DATABASE TO C##LEARNINGLOG CONTAINER=ALL ;

# RUN WITH DOCKER
    ./buildAndDeploy.sh
    
# MAVEN ORACLE DRIVER
    mvn install:install-file -Dfile=ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar

# REST
LIST

    curl -X GET http://localhost:8080/learninglog/resources/post
    OR
    curl -X GET http://localhost:8080/learninglog/resources/post | jq .

CREATE

    curl -d "author=Roki1&text=Batung" -X POST http://localhost:8080/learninglog/resources/post
DELETE

    curl -X DELETE http://localhost:8080/learninglog/resources/post/1