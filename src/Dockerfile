FROM openjdk:21
WORKDIR /app
COPY ./src/carRental /app
COPY ../lib /app
RUN javac DatabaseConnection.java
CMD ["java", "-cp", ".:mysql-connector-j-8.2.0.jar", "DatabaseConnection"]
