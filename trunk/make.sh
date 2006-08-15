#!/bin/bash

if [ "$1" ]
then
	PROCESSING_PATH=$1
fi

rm -rf interfascia
rm interfascia.jar
javac -source 1.3 -target 1.1 -d . -classpath "$PROCESSING_PATH/lib/core.jar" *.java
jar -cf interfascia.jar interfascia
