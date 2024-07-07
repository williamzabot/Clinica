# Use a imagem do OpenJDK 17 com Alpine Linux como base
FROM openjdk:17-alpine

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para o contêiner
COPY build/libs/ClinicaKotlin-0.0.1.jar /app/clinicakotlin.jar

# Comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "clinicakotlin.jar"]
