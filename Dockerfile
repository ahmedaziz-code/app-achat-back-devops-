FROM ubuntu:16.04
RUN apt-get update && apt-get install -y \
curl
RUN curl -u jenkins-user:123 -o achat-1.0.jar "http://192.168.1.156:8081/repository/maven-nexus-repo/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
FROM amazoncorretto:11-alpine-jdk
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]