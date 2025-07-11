# Etapa 1: Construcción con Maven
FROM maven:3.8.7-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos el pom.xml y el código fuente
COPY pom.xml .
COPY src ./src

# Compilamos y empaquetamos el proyecto (sin tests para acelerar)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen runtime ligera
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiamos el .jar compilado desde la etapa build
COPY --from=build /app/target/Juegos-0.0.1-SNAPSHOT.jar appJuegos.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "appJuegos.jar"]