# Use uma imagem base do OpenJDK para JDK 17 (temurin)
FROM adoptopenjdk/openjdk17:alpine-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para o contêiner
COPY build/libs/clinicakotlin.jar /app/clinicakotlin.jar

# Comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "clinicakotlin.jar"]
