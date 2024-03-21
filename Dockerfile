FROM tomcat:8.0.51-jre8-alpine
COPY ./target/Demo*.jar  /usr/local/tomcat/webapps
EXPOSE  8080
USER Demo
WORKDIR /usr/local/tomcat/webapps
CMD ["catalina.sh","run"]