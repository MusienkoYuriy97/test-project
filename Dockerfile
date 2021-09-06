FROM maven:latest AS build
COPY . /test-project
WORKDIR /test-project
RUN mvn clean package -DskipTests

FROM openjdk:latest
COPY --from=build /test-project/target/test-project-0.0.1-SNAPSHOT.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","application.jar"]