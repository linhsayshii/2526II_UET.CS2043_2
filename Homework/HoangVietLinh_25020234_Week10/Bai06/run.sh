#!/bin/bash
ROOT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
mkdir -p "$BUILD_DIR"

echo "Chọn chương trình để chạy:"
echo "  1) CommandServer  (TCP port 5000)"
echo "  2) CommandClient  (TCP)"
echo "  3) SensorReceiver (UDP port 6000)"
echo "  4) SensorSender   (UDP)"
read -p "Nhập số (1-4): " choice

javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

case $choice in
    1) java -cp "$BUILD_DIR" CommandServer ;;
    2) java -cp "$BUILD_DIR" CommandClient ;;
    3) java -cp "$BUILD_DIR" SensorReceiver ;;
    4) java -cp "$BUILD_DIR" SensorSender ;;
    *) echo "Lựa chọn không hợp lệ" ;;
esac
