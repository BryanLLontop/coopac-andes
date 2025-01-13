# Usa una imagen base de Java 17
FROM openjdk:17-slim

# Configura el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado al contenedor
COPY build/libs/losandes-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8081 (el que usa tu aplicación)
EXPOSE 8081

# Define el comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
