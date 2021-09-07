// this is the example build.sbt file that’s shown
// in Recipe 17.3, on p. 498
ThisBuild / scalaVersion := "3.0.0"
ThisBuild / version      := "0.1"

// dependencies as values/variables
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
