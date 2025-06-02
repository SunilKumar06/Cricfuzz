FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Cricfuzz-0.0.1-SNAPSHOT.jar Cricfuzz.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "Cricfuzz.jar"]