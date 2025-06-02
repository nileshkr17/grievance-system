# ---------- Stage 1: Build ----------
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ---------- Stage 2: Run ----------
# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/*.jar app.jar

# Expose the port Render expects (default 10000)
EXPOSE 10000

# Set environment variable for port (Render will set PORT)
ENV PORT=10000

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
