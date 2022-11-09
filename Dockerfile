FROM openjdk:11
ADD http://$IP:8081/repository/stock/tn/esprit/rh/achat/1.0/springprojet.jar springprojet.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat.jar"]
