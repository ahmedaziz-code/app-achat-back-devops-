FROM eclipse-temurin:11-jdk-alpine
ARG IP
ADD http://$IP:8081/repository/maven-nexus-repo/tn/esprit/rh/achat/1.0/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]