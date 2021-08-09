# this requires JDK 14+
# the jar file must be built with sbt-assembly or similar

JAR_FILE=MySwingApp-assembly-0.1.0.jar
MAIN_CLASS=com.alvinalexander.myapp.mySwingApp
APP_NAME=MyApp
TARGET_DIR=../target/scala-3.0.0-RC1

rm Input/${JAR_FILE}          2> /dev/null
rm -rf Output/${APP_NAME}.app 2> /dev/null

# get the latest sbt-assembly jar file
cp ${TARGET_DIR}/${JAR_FILE} Input

# creates Output/MyApp.app (a MacOS app)
echo "Creating a macOS app with jpackage ..."
jpackage \
  --name $APP_NAME \
  --type app-image \
  --input Input \
  --dest Output \
  --main-jar $JAR_FILE \
  --main-class $MAIN_CLASS

# specify an app icon
# --icon Input/MyApp.icns \

echo "Created Output/MyApp.app (hopefully)"
