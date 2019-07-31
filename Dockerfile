FROM openjdk:10-jre-slim

LABEL Name="Movie Service" \
            Product="ShowTimes"

EXPOSE 8080

RUN mkdir /container
COPY build/libs/bookmyshow-0.0.1-SNAPSHOT.jar /container/showtimes-api.jar

WORKDIR /container

ENTRYPOINT exec java $JAVA_OPTS -jar showtimes-api.jar