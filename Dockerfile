FROM azul/zulu-openjdk:17.0.0-17.28.13-jre-headless

WORKDIR /app

ENV APPLICATION_PROFILE ${APPLICATION_PROFILE:-local}

RUN apt update && apt-get -y install curl
RUN curl -o newrelic.jar https://download.newrelic.com/newrelic/java-agent/newrelic-agent/7.4.0/newrelic-agent-7.4.0.jar
COPY newrelic.yml .

COPY target/skeleton*.jar skeleton.jar

CMD java \
  -Dspring.profiles.active=${APPLICATION_PROFILE} \
  -Xmx800m \
  -javaagent:newrelic.jar \
  -jar skeleton.jar