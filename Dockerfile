# Use the official Gradle image with JDK 17 as the base image
FROM gradle:7.4.1-jdk17 AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

CMD ["java", "-Dspring.profiles.active=dev", "-jar", "clinicakotlin.jar"]
