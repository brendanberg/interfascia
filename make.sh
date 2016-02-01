#!/bin/bash

# This script is outdated but included for future archeological interest.
# Please use the ant build system to create the interfascia.jar file.

if [ "$1" ]
then
	PROCESSING_PATH=$1
fi

rm -rf build/*
rm interfascia.jar
javac -source 1.3 -target 1.1 -d build -classpath "$PROCESSING_PATH/core.jar" interfascia/*.java
jar -cf interfascia.jar build/interfascia data