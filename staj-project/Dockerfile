# RUNNING THE APP
FROM openjdk:17-jdk-slim
WORKDIR /app

#copy jar
COPY target/staj-project-0.0.1-SNAPSHOT.jar app.jar

# Setup an app user so the container doesn't run as the root user
RUN useradd -m appuser
#uid
USER appuser

#port number
EXPOSE 8080
#start app
ENTRYPOINT ["java", "-jar", "app.jar"]
