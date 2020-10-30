#!/bin/bash
#
# Start SonarQube
./bin/run.sh &

JAVA_LANGUAGE=java
JAVA_PROFILE_NAME=JavaStandardProfile
JS_LANGUAGE=javascript
JS_PROFILE_NAME=JSStandardProfile
BASE_URL=http://127.0.0.1:9000

function isUp {
  curl -s -u admin:admin -f "$BASE_URL/api/system/info"
}

# Wait for server to be up
PING=`isUp`
while [ -z "$PING" ]
do
  sleep 5
  PING=`isUp`
done

# Restore qualityprofile
curl -v -u admin:admin -F "backup=@/qualityprofile/java-standardprofile.xml" -X POST "$BASE_URL/api/qualityprofiles/restore"
curl -v -u admin:admin -X POST "$BASE_URL/api/qualityprofiles/set_default?language=$JAVA_LANGUAGE&profileName=$JAVA_PROFILE_NAME"

curl -v -u admin:admin -F "backup=@/qualityprofile/javascript-standardprofile.xml" -X POST "$BASE_URL/api/qualityprofiles/restore"
curl -v -u admin:admin -X POST "$BASE_URL/api/qualityprofiles/set_default?language=$JS_LANGUAGE&profileName=$JS_PROFILE_NAME"

wait