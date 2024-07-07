# Use uma imagem base do Java 17
FROM openjdk:latest

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Adiciona comandos para imprimir informações e listar diretórios
RUN echo "Current directory" && pwd
RUN echo "Listing files in /app: " && ls -l

# Copia o arquivo JAR da sua aplicação para o contêiner
COPY clinicakotlin.jar /app/clinicakotlin.jar

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "clinicakotlin.jar"]

