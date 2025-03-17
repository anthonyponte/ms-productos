FROM openjdk:21-jdk-slim
WORKDIR /app
EXPOSE 9095
COPY target/msproductos-0.0.2-SNAPSHOT.jar msproductos.jar
ENTRYPOINT ["java", "-jar", "msproductos.jar"]