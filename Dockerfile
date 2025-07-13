# Usamos una imagen oficial de Java 21
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos todo el proyecto al contenedor
COPY . .

# Instalamos dependencias y construimos el JAR
RUN ./mvnw clean package -DskipTests

# Exponemos el puerto donde corre Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "./target/contactform-0.0.1-SNAPSHOT.jar"]
