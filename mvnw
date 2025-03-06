#!/usr/bin/env sh
set -e

# Maven wrapper script

MAVEN_VERSION=3.8.6
MVNW_HOME="$HOME/.m2/wrapper/dists/apache-maven-$MAVEN_VERSION-bin"
MVNW_CMD="$MVNW_HOME/mvnw"

if [ ! -f "$MVNW_CMD" ]; then
  echo "Downloading Maven wrapper..."
  mkdir -p "$MVNW_HOME"
  curl -L "https://archive.apache.org/dist/maven/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz" | tar xz -C "$MVNW_HOME" --strip-components=1
fi

exec "$MVNW_CMD" "$@"