# Use uma imagem base do Java 17
FROM openjdk:latest

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o contêiner
COPY clinicakotlin.jar /app/clinicakotlin.jar

# Adiciona comandos para imprimir informações e listar diretórios
RUN echo "Current directory: $(pwd)"
RUN echo "Listing files in /app:"
RUN ls -l

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "clinicakotlin.jar"]

