#!/bin/sh

rm -rf build || true

./gradlew build

./gradlew apps:java-application:run