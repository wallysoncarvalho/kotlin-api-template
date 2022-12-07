FROM openjdk:17-alpine
WORKDIR /app
COPY ./build/libs/kotlin-api-template-1.0.jar app.jar
ENTRYPOINT java -jar app.jar
