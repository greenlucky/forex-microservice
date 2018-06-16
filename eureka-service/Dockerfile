FROM openjdk:8-jdk-alpine
MAINTAINER Lam Nguyen <lamnguyenit86@gmail.com>
ADD target/eureka-service.jar eureka-service.jar
ENTRYPOINT ["java", "-jar", "/eureka-service.jar"]
EXPOSE 8761