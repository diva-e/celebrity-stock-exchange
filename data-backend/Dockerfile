FROM anapsix/alpine-java:8
#ENTRYPOINT ["java", "-jar", "-Xmx2g", "-Xms1g", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=9010", "-Dcom.sun.management.jmxremote.host=0.0.0.0", "-Dcom.sun.management.jmxremote.authenticate=false", "-Dcom.sun.management.jmxremote.ssl=false", "-Dcom.sun.management.jmxremote.local.only=false", "-Dcom.sun.management.jmxremote.rmi.port=9010", "-Djava.rmi.server.hostname=0.0.0.0", "/data-backend.jar", "--spring.config.additional-location=/srv/conf/"]
ARG JAR_FILE
ADD target/${JAR_FILE} /data-backend.jar
