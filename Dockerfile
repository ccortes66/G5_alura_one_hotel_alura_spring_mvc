FROM maven:3.9.4-eclipse-temurin-17-alpine as builder

COPY ./src src/
COPY ./pom.xml pom.xml
COPY ./memory:myDb?cache=shared memory:myDb?cache=shared

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
COPY --from=builder target/*.jar app.jar
COPY --from=builder memory:myDb?cache=shared memory:myDb?cache=shared
EXPOSE 8080
ENTRYPOINT [ "java","-jar", "app.jar"]