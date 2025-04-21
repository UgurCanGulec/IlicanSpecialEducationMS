FROM gradle:7.5.1-jdk17 as builder
WORKDIR /app
COPY . /app
RUN gradle build -x test
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/ilican-special-education-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
