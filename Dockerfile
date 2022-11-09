FROM openjdk:11
EXPOSE 8082
ADD target/achat.jar achatt.jar
ENTRYPOINT ["java","-jar","/achat.jar"]
