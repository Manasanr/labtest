# Stage 1: Runtime Environment
FROM eclipse-temurin:17-jre-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the built jar file from the Maven target directory into the container
# Replace 'your-artifact-name.jar' with your actual jar filename or use a wildcard *.jar
COPY target/*.jar app.jar

# Expose the port your Spring Boot / Java application runs on (default is usually 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]