FROM ubuntu:16.04
RUN apt-get update && apt-get install -y \
curl
RUN curl -u jenkins-user:123 -o achat-1.0.jar "http://192.168.1.5:8081/repository/maven-nexus-repo/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
FROM eclipse-temurin:8-alpine
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]