FROM openjdk:8-jre-alpine

EXPOSE 8089

COPY ./target/achat-1.0.jar /usr/app/


WORKDIR /usr/app

CMD java -jar achat-1.0.jar
