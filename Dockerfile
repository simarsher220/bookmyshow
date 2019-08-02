#FROM openjdk:10-jre-slim
#
#LABEL Name="Movie Service" \
#            Product="ShowTimes"
#
#EXPOSE 8080
#
#RUN mkdir /container
#COPY build/libs/bookmyshow-0.0.1-SNAPSHOT.jar /container/showtimes-api.jar
#
#WORKDIR /container
#
#ENTRYPOINT exec java $JAVA_OPTS -jar showtimes-api.jar

FROM openjdk:10-jre-slim
COPY src /tmp/src/
COPY build.gradle /tmp/
COPY gradlew /tmp/
COPY gradle /tmp/gradle/
WORKDIR /tmp/

EXPOSE 8080

RUN ./gradlew build
RUN ./gradlew bootJar

ENTRYPOINT ["java", "-jar", "./build/libs/spring-boot-in-docker.jar"]