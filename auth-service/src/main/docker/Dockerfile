FROM openjdk:8-jre-alpine

MAINTAINER suxi

ARG JAR_FILE
ADD ${JAR_FILE} /app.jar

EXPOSE 18001

ENTRYPOINT ["java","-jar","/app.jar"]