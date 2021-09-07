lazy val root = project
    .in(file("."))
    .settings(
        name := "MySwingApp",
        version := "0.1.0",
        scalaVersion := "3.0.1"
    )

// docs: “To only fork Compile / run and Compile / runMain”:
Compile / run / fork := true

