FROM openjdk:8-jdk-alpine
ADD target/docker-administrator.jar docker-administrator.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","docker-administrator.jar"]