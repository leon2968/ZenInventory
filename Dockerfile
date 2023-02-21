# Use the official maven/Java 17 image to create a build artifact.
# https://hub.docker.com/_/maven
FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

ENV JAVA_TOOL_OPTIONS="-Dserver.address=0.0.0.0"

# Use AdoptOpenJDK for the runtime image.
# https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:latest
WORKDIR /app
COPY --from=build /app/target/zeninventory*.jar .
EXPOSE 8080
CMD ["java", "-jar", "zeninventory-0.0.1-SNAPSHOT.jar"]
