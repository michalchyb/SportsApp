FROM openjdk:8u201-jdk-alpine3.9
ADD target/docker-app.jar docker-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "docker-app.jar"]