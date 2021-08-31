#!/bin/sh

rm -rf build/

./gradlew clean

./gradlew build

mkdir -p build/plugins

cp apps/spring-application/build/libs/spring-application.jar build/
cp plugins/plugin-welcome/build/libs/welcome-plugin-0.0.1.zip build/plugins/
cp spring-plugin/build/libs/spring-plugin-0.0.1.zip build/plugins/
cp plugins/plugin-fancy/build/libs/fancy-plugin-0.0.1.zip build/plugins/

cd build || exit 1

java -jar spring-application.jar

#unzip spring-application.jar
