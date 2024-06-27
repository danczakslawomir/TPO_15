FROM openjdk:21-slim-bullseye
EXPOSE 8080
COPY build/libs/TPO_15-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
