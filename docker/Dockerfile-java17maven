# Use the official Maven image as the build environment
FROM maven:3.8.4-jdk-17 AS build

# Copy the source code into the container
COPY . /app

# Set the working directory
WORKDIR /app

# Build the application with Maven
RUN mvn package

# Use the official OpenJDK image as the runtime environment
FROM openjdk:17-jdk-alpine AS runtime

# Copy the built JAR file from the build environment to the runtime environment
COPY --from=build /app/target/zeninventory.jar /app/zeninventory.jar

# Set the working directory
WORKDIR /app

# Start the application
CMD ["java", "-jar", "zeninventory.jar"]