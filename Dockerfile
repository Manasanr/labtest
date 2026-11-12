
# Stage 1: Build the Java application
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven project files
COPY pom.xml .

COPY src ./src

# Compile and package the application
RUN mvn clean package

# Stage 2: Run the application
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the generated JAR from the build stage
COPY --from=build /app/target/maven-lab-0.0.1-SNAPSHOT.jar app.jar

# Run the Java application
CMD ["java", "-cp", "app.jar", "com.example.maven_lab.App"]
