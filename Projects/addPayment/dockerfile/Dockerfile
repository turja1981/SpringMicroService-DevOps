FROM openjdk:8-jre-alpine
ADD AddPayment.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 3333
