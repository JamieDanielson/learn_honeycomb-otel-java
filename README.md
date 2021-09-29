# learn_honeycomb-otel-java

## Initial Project Setup

The application is based on [Spring Boot Starter for MySQL](https://spring.io/guides/gs/accessing-data-mysql/).

To see the full setup, use the settings in [SpringBootStarter](/SpringBootStarter.md) and follow the guide. Some changes were made to this example, including changing "User" to "Bee" wherever mentioned, and removing email to simplify things.

A ready example (no o11y yet!) can be found in the 'bees-starter' directory.

`./gradlew bootRun` from the 'bees-starter' directory

`curl localhost:8080/demo/add -d name=Jamie` to add a bee named Jamie.

`curl localhost:8080/demo/all` to see all the bees.
