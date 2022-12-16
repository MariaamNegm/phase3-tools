FROM openjdk:19
ADD target/docker-spring-boot.jar  app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]