@echo off
cd /d "%~dp0"
javac src\Solution.java -d bin
java -cp bin Solution

::optional
rmdir /s /q bin
pause