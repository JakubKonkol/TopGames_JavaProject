FROM openjdk:18.0.1-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./mvn clean install
EXPOSE 8081
CMD ["java", "-jar", "target/topgames-web-api-0.0.1-SNAPSHOT.jar"]
