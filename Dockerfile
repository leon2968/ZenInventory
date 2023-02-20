# Use the official maven/Java 17 image to create a build artifact.
# https://hub.docker.com/_/maven
FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use AdoptOpenJDK for the runtime image.
# https://hub.docker.com/_/adoptopenjdk
FROM adoptopenjdk:17-jre-hotspot
WORKDIR /app
COPY --from=build /app/target/my-app.jar .
EXPOSE 8080
CMD ["java", "-jar", "my-app.jar"]
