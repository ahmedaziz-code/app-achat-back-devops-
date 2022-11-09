FROM openjdk:11
EXPOSE 8082
ADD target/springprojet.jar springprojet.jar
ENTRYPOINT ["java","-jar","/springprojet.jar"]
