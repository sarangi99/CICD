# SkyTrail — Java WAR Website

A small travel-themed website for practicing Maven, Jenkins, and Apache Tomcat deployment.

## Requirements
- JDK 11 or newer
- Maven 3.6+
- Apache Tomcat 9.x (uses the `javax.servlet` API)

## Build locally
From the project root:

```bash
mvn clean package
```

The deployable file will be:

```text
target/java-war-website.war
```

## Deploy to Tomcat
1. Copy `target/java-war-website.war` to Tomcat's `webapps/` directory.
2. Start or restart Tomcat.
3. Open `http://YOUR_SERVER:8080/java-war-website/`

Example on a Linux host (adjust the Tomcat path to your installation):

```bash
sudo cp target/java-war-website.war /opt/tomcat/webapps/
```

## Jenkins Freestyle job
1. Configure the Git repository URL for this project.
2. Add a build step: **Invoke top-level Maven targets**.
3. Set Goals to `clean package`.
4. Add **Deploy war/ear to a container** only after configuring a Tomcat 9 server and its deployment credentials.
5. Set **WAR/EAR files** to `target/*.war`.

If you use a shell build step instead, run `mvn clean package`.

## What to practice
- Git checkout from GitHub
- Maven WAR packaging
- Jenkins build and test automation
- Tomcat deployment
- Updating the website and triggering a new build

The contact form uses a Java Servlet and displays a confirmation page. It does not store submissions in a database. This is a practice project, not a production-ready website.
