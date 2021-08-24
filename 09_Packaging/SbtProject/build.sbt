val scala3Version = "3.0.1"

lazy val root = project
    .in(file("."))
    .settings(
        name := "Packaging",
        version := "0.1.0",
        scalaVersion := scala3Version
    )
