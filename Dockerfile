FROM ubuntu
RUN apt-get update
RUN apt-get install -y openjdk-17-jdk

WORKDIR /app

COPY target/java-maven-app-final-2.2.0-SNAPSHOT.jar /app
EXPOSE 8080
CMD [ "java", "-jar" , "java-maven-app-final-2.2.0-SNAPSHOT.jar" ]
