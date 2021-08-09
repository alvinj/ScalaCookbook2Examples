lazy val root = project
    .in(file("."))
    .settings(
        name := "RunJarFile",
        description := "Show how to use assembly and run jar files",
        version := "0.1.0",
        scalaVersion := "3.0.1"
    )

// set the main class for 'sbt run'
mainClass in (Compile, run) := Some("hello")

// set the main class for packaging the main jar
mainClass in (Compile, packageBin) := Some("hello")
