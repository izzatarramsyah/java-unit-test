FROM openjdk:8-jre-alpine
ENV java_opts=""
ENV java_args=""
WORKDIR /app
COPY target/demo*.jar /app/app.jar
ENTRYPOINT exec java $java_opts -jar app.jar $java_args
EXPOSE 8090