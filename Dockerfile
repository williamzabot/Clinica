# Use uma imagem base do Java 17
FROM openjdk:latest

# Copia o arquivo JAR da sua aplicação para o contêiner
COPY clinicakotlin.jar /app/clinicakotlin.jar

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "clinicakotlin.jar"]

