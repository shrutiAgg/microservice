FROM java:8
VOLUME /tmp
ADD target/microservices-0.0.1-SNAPSHOT.jar tickets.jar
RUN bash -c 'touch /tickets.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /tickets.jar"]
 