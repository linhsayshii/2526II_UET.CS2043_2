#!/bin/bash
cd "$(dirname "$0")"
javac ./src/HelloWorld.java -d ./bin
#clear
java -cp ./bin HelloWorld

#optional
rm -rf ./bin
read -p "Press Enter to exit..."