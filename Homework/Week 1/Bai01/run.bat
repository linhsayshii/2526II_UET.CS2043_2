@echo off
cd /d "%~dp0"
javac src\HelloWorld.java -d bin
java -cp bin HelloWorld

::optional
rmdir /s /q bin
pause