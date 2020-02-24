#!/usr/bin/env bash
#Simple Bash Script for setting up, compiling and running our Scanner


antlr4='java -jar /usr/local/lib/antlr-4.8-complete.jar'
grun='java org.antlr.v4.gui.TestRig'
export CLASSPATH=".:/usr/local/lib/antlr-4.8-complete.jar:$CLASSPATH"

$antlr4 LITTLE.g4
javac LITTLE*.java
java lexerMain.java $1
