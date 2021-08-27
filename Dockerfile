FROM adoptopenjdk/openjdk11:ubi

ADD . /app
WORKDIR /app

RUN ./mvnw clean deploy -DskipTests
RUN mv target/spring-webflux-mongo-app-0.0.1-*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080