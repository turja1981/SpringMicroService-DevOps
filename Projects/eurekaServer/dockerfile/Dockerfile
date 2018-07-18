FROM openjdk:8-jre-alpine
ADD EurekaServer.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 2222
