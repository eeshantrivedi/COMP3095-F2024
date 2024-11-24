#-------------
# Build Stage
#-------------
FROM gradle:8-jdk22 AS builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

RUN gradle build -x test


#-----------
# Package
#-----------
FROM openjdk:22-jdk

# Create an app directory
RUN mkdir /app

# Copy the built jar from the builder stage to the app directory
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/inventory-service.jar

# Set environment variables for database configuration if needed
ENV POSTGRES_DB=inventory-service \
    POSTGRES_USER=admin \
    POSTGRES_PASSWORD=password

# Expose the application port
EXPOSE 8083

# Start the application
ENTRYPOINT ["java", "-jar", "/app/inventory-service.jar"]