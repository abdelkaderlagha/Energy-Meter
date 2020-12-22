# Welcome to # Energy-Meter!

This repo is for the application Energy Meter. Developped by: Spring Boot to make the service part / Thymeleaf to test the services / H2 Database for development / MySql database for QA. 

It uses Circle Ci for the TDD ( Test-driven development ). 

See the frontend (thymeleaf) : localhost:8080 
See the Swagger UI for the Rest Api documentation: localhost:8080/api/energy/swagger-ui


### Apache Kafka

For the Apache Kafka datapoint stream: 
1- Go to ressource directory 
2- run : docker-composer up 
3- create a cluster 
4- create a topic named : Energy_Readings 
5- use localhost:8080/api/energy/publish to start publishing datapoint for energy data.



