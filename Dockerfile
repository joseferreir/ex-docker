FROM tomcat
ENV DEPLOY_DIR ${CATALINA_HOME}/webapps
COPY target/teste-docker.war ${DEPLOY_DIR}/teste-docker.war
