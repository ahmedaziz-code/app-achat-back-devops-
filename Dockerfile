FROM openjdk:11
ADD target/springprojet.jar springprojet.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat.jar"]
