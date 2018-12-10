# Metrics service

## Requirements
- Java runtime version 1.8 or later 
- Gradle version 4.0 or later
- MySQL database version 5.0 or later

## Deployment 
Clone the reposiroty: ```git clone git@github.com:mikemirten/JavaTest.git```

Set up MySQL database.
By default a clean database named "test" expecting at 127.0.0.1:3306 with username and password: "test".
Update ```src/main/resources/application.properties``` if name/credentials are different.

Make sure nothing using port 8080.

Build and run application by: ```gradle bootRun``` command.
The application should be accessible at 127.0.0.1:8080.
