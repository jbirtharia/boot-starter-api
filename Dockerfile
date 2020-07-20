#FROM openjdk:8-jdk-alpine
#ADD target/boot-docker-1.0.jar boot-docker-1.0.jar
#ENTRYPOINT ["sh","-c","java -jar /boot-docker-1.0.jar"]


#Made Generic Docker file. Can use following commands in any Dockerfile
FROM openjdk:8-jdk-alpine
ADD target/*.jar app.jar
ENTRYPOINT ["sh","-c","java -jar /app.jar"]