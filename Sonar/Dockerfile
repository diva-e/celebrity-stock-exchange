
FROM sonarqube:6.3

ENV SONAR_DOWNLOAD_URL https://sonarsource.bintray.com/Distribution

# Installing Plugins
RUN cd /opt/sonarqube/extensions/plugins/
RUN curl -o sonar-java-plugin.jar -fSL $SONAR_DOWNLOAD_URL/sonar-java-plugin/sonar-java-plugin-4.8.0.9441.jar
RUN curl -o sonar-web-plugin.jar -fSL $SONAR_DOWNLOAD_URL/sonar-web-plugin/sonar-web-plugin-2.5.0.476.jar
RUN curl -o sonar-scm-git-plugin.jar -fSL $SONAR_DOWNLOAD_URL/sonar-scm-git-plugin/sonar-scm-git-plugin-1.2.jar
RUN curl -o sonar-javascript-plugin.jar -fSL $SONAR_DOWNLOAD_URL/sonar-javascript-plugin/sonar-javascript-plugin-2.21.1.4786.jar
RUN curl -o sonar-checkstyle-plugin.jar -fSL $SONAR_DOWNLOAD_URL/sonar-checkstyle-plugin/sonar-checkstyle-plugin-2.4.jar

# Add default quality profiles
ADD qualityprofiles/java-standardprofile.xml /qualityprofiles/
ADD qualityprofiles/javascript-standardprofile.xml /qualityprofiles/

#VOLUME ["$SONARQUBE_HOME/data", "$SONARQUBE_HOME/extensions", "/qualityprofiles"]

ADD start_with_profiles.sh /opt/sonarqube/start_with_profiles.sh

ENTRYPOINT ["/opt/sonarqube/start_with_profiles.sh"]