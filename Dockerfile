FROM openjdk:11
COPY ./target/Calculator_mini_project-1.0-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-jar", "Calculator_mini_project-1.0-SNAPSHOT.jar"]
