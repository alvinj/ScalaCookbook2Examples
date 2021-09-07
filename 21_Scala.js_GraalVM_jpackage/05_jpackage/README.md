# jpackage example

This source code corresponds to Recipe 21.5 in the Scala Cookbook, “Bundling Your Application with jpackage.”

To use the code in this project, and assuming that you’re on a Mac:

1. Create a complete JAR file with the `sbt assembly` command, as shown in the Cookbook.
2. `cd` into the *jpackage* directory.
3. Make sure you are using JDK 14 or newer.
4. Run the *CreatePackage.sh* shell script.
5. That script should create an output app, which you can open and run with this command:

```sh
open Output/MyApp.app
```

Note that the variables used in the CreatePackage.sh file correspond to the settings in the build.sbt file, so when you change one you also need to change the other.
