FROM openjdk:17-oracle

WORKDIR /app

COPY build/libs/Spring-boot-homework-2-7-0.0.1-SNAPSHOT.jar app.jar

ENV INIT_DEFAULT_DATA=true

CMD ["java", "-jar", "app.jar"]