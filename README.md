# MavenDemo

A small Java 11-compatible Maven project for practicing Maven goals.

## Requirements
- JDK 11 or newer (a newer JDK can compile with `maven.compiler.release=11`)
- Maven

## Commands
```bash
mvn validate
mvn clean
mvn compile
mvn test
mvn package
mvn install
mvn clean package
```

## Run the application
```bash
java -cp target/classes com.example.App
```

The packaged JAR is created under `target/`.
