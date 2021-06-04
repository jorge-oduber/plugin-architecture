#!/bin/sh

rm -rf build || true

./gradlew build -x spring-plugin:build

./gradlew apps:java-application:run