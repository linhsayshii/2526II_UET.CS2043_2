#!/bin/bash
ROOT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
SRC_DIR="$ROOT_DIR/src"
TEST_DIR="$ROOT_DIR/test"
BUILD_DIR="$ROOT_DIR/build"
LIB_DIR="$ROOT_DIR/lib"

mkdir -p "$BUILD_DIR" "$LIB_DIR"

# Tải JUnit 5 nếu chưa có
JUNIT_JAR="$LIB_DIR/junit-platform-console-standalone-1.10.2.jar"
if [ ! -f "$JUNIT_JAR" ]; then
    echo "Đang tải JUnit 5..."
    curl -sL "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar" -o "$JUNIT_JAR"
fi

# Biên dịch source
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

# Biên dịch test
javac -cp "$BUILD_DIR:$JUNIT_JAR" -d "$BUILD_DIR" "$TEST_DIR"/*.java

# Chạy test
java -jar "$JUNIT_JAR" --class-path "$BUILD_DIR" --scan-class-path
