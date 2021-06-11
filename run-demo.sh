#!/bin/sh

rm -rf build || true

./gradlew build -x spring-plugin:build

cp apps/java-application/build/libs/*.jar build/
cp -R apps/java-application/build/libs/lib build/
cp plugins/plugin-welcome/build/libs/welcome-plugin-*.zip build/plugins/
cp plugins/plugin-hello/build/libs/hello-plugin-*.zip build/plugins/

#./gradlew apps:java-application:run

cd build || exit 1

java -jar java-application.jar
