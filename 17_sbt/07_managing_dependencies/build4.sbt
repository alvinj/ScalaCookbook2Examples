// this example demonstrates the preferred
// sbt syntax, with multiple dependencies

ThisBuild / scalaVersion := "3.0.1"
ThisBuild / version      := "0.1"

val catsCore = "org.typelevel" %% "cats-core" % "2.6.0"
val catsEffect = "org.typelevel" %% "cats-effect" % "3.1.0"

lazy val root = (project in file("."))
    .settings(
        name := "MyProject",
        libraryDependencies ++= Seq(
            catsCore,
            catsEffect
        )
    )
