# Use the official Gradle image with JDK 17 as the base image
FROM openjdk:21-jdk-slim as build

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

EXPOSE 9001

CMD ["java", "-jar", "clinicakotlin.jar"]
