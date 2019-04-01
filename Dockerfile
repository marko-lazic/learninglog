FROM airhacks/glassfish
COPY ./target/learninglog.war ${DEPLOYMENT_DIR}
