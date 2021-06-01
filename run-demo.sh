#!/bin/sh

rm -rf build || true

./gradlew build

./gradlew app:run