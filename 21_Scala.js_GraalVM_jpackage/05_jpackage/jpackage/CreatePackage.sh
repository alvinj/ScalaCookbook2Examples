# this requires JDK 14+.
# the jar file must be built with sbt-assembly or similar.

JAR_FILE=MySwingApp-assembly-0.1.0.jar
MAIN_CLASS=com.alvinalexander.myapp.mySwingApp
APP_NAME=MyApp
TARGET_DIR=../target/scala-3.0.1

# remove old stuff from previous builds
rm Input/${JAR_FILE}          2> /dev/null
rm -rf Output/${APP_NAME}.app 2> /dev/null

# get the latest sbt-assembly jar file, which this script
# assumes is built and in this location
cp ${TARGET_DIR}/${JAR_FILE} Input

# creates Output/MyApp.app (a MacOS app)
echo "Creating a macOS app with jpackage ..."
jpackage \
    --name $APP_NAME \
    --type app-image \
    --input Input \
    --dest Output \
    --main-jar $JAR_FILE \
    --main-class $MAIN_CLASS \
    --icon Input/MyApp.icns

echo "Created Output/MyApp.app (hopefully)"


