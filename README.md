# Build
mvn clean package && docker build -t ml.markolazic/learninglog .

# RUN

docker rm -f learninglog || true && docker run -d -p 8080:8080 -p 4848:4848 --name learninglog ml.markolazic/learninglog 