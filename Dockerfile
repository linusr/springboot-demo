FROM openjdk:11

RUN mkdir /app
WORKDIR /app
COPY ./build/libs/MenuApp-0.0.1-SNAPSHOT.jar ./app.jar

CMD ["java", "-jar", "/app/app.jar"]