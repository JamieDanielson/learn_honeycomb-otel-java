# learn_honeycomb-otel-java

## Initial Project Setup

The application is based on [Spring Boot Starter for MySQL](https://spring.io/guides/gs/accessing-data-mysql/).

To see the full setup, use the settings in [SpringBootStarter](/SpringBootStarter.md) and follow the guide. Some changes were made to this example, including changing "User" to "Bee" wherever mentioned, and removing email to simplify things.

A ready example (no o11y yet!) can be found in the 'bees-starter' directory.

`./gradlew bootRun` from the 'bees-starter' directory

`curl localhost:8080/demo/add -d name=Jamie` to add a bee named Jamie.

`curl localhost:8080/demo/all` to see all the bees.

## Running with OTel Java Agent

Download [agent jar](https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent-all.jar)
Add some env vars based on [otel java config](https://github.com/open-telemetry/opentelemetry-java/blob/main/sdk-extensions/autoconfigure/README.md#otlp-exporter-both-span-and-metric-exporters):

export HONEYCOMB_API_KEY=apikey123
export HONEYCOMB_DATASET=bees
export OTEL_EXPORTER_OTLP_ENDPOINT=https://api.honeycomb.io
export OTEL_EXPORTER_OTLP_TRACES_ENDPOINT=${OTEL_EXPORTER_OTLP_ENDPOINT}
export OTEL_EXPORTER_OTLP_HEADERS=‘x-honeycomb-team=${HONEYCOMB_API_KEY},x-honeycomb-dataset=${HONEYCOMB_DATASET}’

Run the agent alongside your app. Easiest way is to build your own jar and run them both:

run from 'bees-starter' directory:

`./gradlew build` - this creates a `.jar` file in `/build/libs`

`java -javaagent:opentelemetry-javaagent-all.jar -jar ./build/libs/bees-starter-0.0.1-SNAPSHOT.jar`

When you get all bees (`curl localhost:8080/demo/all`) it will create a trace like this:

![Vanilla OTel Agent Trace - Demo / All](/vanilla-otel-agent-trace-all.png)

When you add a bee (`curl localhost:8080/demo/add -d name=Jamie`) it will create a trace like this:

![Vanilla OTel Agent Trace - Demo / Add](/vanilla-otel-agent-trace-add.png)
