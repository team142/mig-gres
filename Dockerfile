FROM jetty:9.4-jre8-alpine
ADD ./target/*.war /var/lib/jetty/webapps/ROOT.war