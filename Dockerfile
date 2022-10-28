FROM eclipse-temurin:11-jdk-alpine
ADD http://192.168.1.5:8081/repository/maven-nexus-repo/tn/esprit/rh/achat/1.0/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]