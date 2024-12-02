FROM openjdk:21-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app.jar

WORKDIR /Atlas

COPY .env .env

EXPOSE 8085

RUN echo '#!/bin/sh' > /entrypoint.sh \
    && echo 'export $(grep -v "^#" .env | xargs)' >> /entrypoint.sh \
    && echo 'exec java -jar /app.jar' >> /entrypoint.sh \
    && chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
