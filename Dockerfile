FROM openjdk:11
ADD http://$IP:8081/repository/stock/tn/esprit/rh/achat/1.0/achat-1.0.pom achat-1.0.pom
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat.jar"]
