FROM openjdk:21-jdk-slim
WORKDIR /app
EXPOSE 9095
COPY target/ms-productos-backend-0.0.1-SNAPSHOT.jar ms-productos-backend.jar
ENTRYPOINT ["java", "-jar", "ms-productos-backend.jar"]