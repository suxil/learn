FROM openjdk:latest

MAINTAINER suxi

ARG JAR_FILE
ADD ${JAR_FILE} /app.jar

EXPOSE 18091

ENTRYPOINT ["java","-jar","/app.jar"]