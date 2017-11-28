FROM jetty:9.4-jre8-alpine
ADD ./target/*.war /var/lib/jetty/webapps/ROOT.war

RUN mkdir /var/lib/jetty/MIG_GRES_PATH