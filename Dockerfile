FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-Dserver.port=${PORT}","-Dserver.address=0.0.0.0","-jar","app.jar"]
