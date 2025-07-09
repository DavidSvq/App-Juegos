FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/Juegos-0.0.1-SNAPSHOT.jar appJuegos.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "appJuegos.jar"]