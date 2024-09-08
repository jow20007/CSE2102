#!/bin/bash

# pwd
# cd src
# javac c/*.java
# cd ..

javac -cp "junit-4.13.2.jar:src" "./src/c/Hybrid.java" "./src/u/TestCar.java"
java -cp "junit-4.13.2.jar:hamcrest-core-1.3.jar:./src/" org.junit.runner.JUnitCore u.TestCar