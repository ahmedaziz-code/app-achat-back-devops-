FROM openjdk:11
ADD target/achat.jar achat.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat.jar"]
