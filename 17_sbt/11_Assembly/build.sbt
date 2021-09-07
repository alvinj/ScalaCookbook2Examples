lazy val root = project
    .in(file("."))
    .settings(
        name := "MyProject",
        version := "0.1.0",
        scalaVersion := "3.0.1",
        assembly / mainClass := Some("com.alvinalexander.myproject.Foo"),
        assembly / assemblyJarName := "MyApp.jar",
        assembly / test := {}
    )
