FROM amazoncorretto:11-alpine-jdk
RUN curl -u jenkins-user:123 -o achat-1.0.jar "http://0.0.0.0:8081/repository/maven-nexus-repo/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]