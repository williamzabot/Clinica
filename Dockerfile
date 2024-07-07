# Use uma imagem base do OpenJDK 17
FROM openjdk:latest

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o jar construído para o contêiner
RUN ls
RUN pwd
COPY clinicakotlin.jar /app/clinicakotlin.jar

# Comando para executar a aplicação quando o contêiner iniciar
CMD ["java", "-jar", "app.jar"]
