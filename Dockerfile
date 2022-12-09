FROM openjdk:17
COPY /target .
EXPOSE 10000
CMD ["java", "-jar", "eureka-service-0.0.1-SNAPSHOT.jar"]