FROM openjdk:28-ea-oraclelinux10

WORKDIR /app

COPY target/java-maven-app-final-2.2.0-SNAPSHOT.jar /app
EXPOSE 8080
CMD [ "java", "-jar" , "java-maven-app-final-2.2.0-SNAPSHOT.jar" ]
