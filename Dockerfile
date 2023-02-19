#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
#WORKDIR /workspace/app

COPY . .

# unpack fat jar
RUN mvn clean #package
RUN mvn spring-boot:build-image
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#
# Package stage
#
#FROM openjdk:17-jdk-slim
#COPY --from=build /target/zeninventory-0.0.1-SNAPSHOT.jar app.jar
# ENV PORT=8080
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","app.jar"]
#FROM openjdk:17-jdk-slim
#VOLUME /tmp
#ARG DEPENDENCY=/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","zeninventory.Application"]
