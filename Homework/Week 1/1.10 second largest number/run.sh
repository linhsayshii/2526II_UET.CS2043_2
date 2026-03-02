#!/bin/bash
cd "$(dirname "$0")"
javac ./src/Solution.java -d ./bin
#clear
java -cp ./bin Solution

#optional
rm -rf ./bin
read -p "Press Enter to exit..."