FROM openjdk:11

ARG JAR_FILE
COPY target/*.jar app.jar

EXPOSE 8080/tcp
ENTRYPOINT ["java", "-jar","/app.jar"]