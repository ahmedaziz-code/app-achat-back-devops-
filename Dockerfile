FROM openjdk:8
ADD target/devopsproject.jar devopsproject.jar
EXPOSE 8089
ENTRYPOINT [ "java", "-jar", "achatproject-1.0.jar" ]
