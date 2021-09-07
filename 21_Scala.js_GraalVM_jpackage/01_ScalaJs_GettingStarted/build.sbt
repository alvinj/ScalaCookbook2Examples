ThisBuild / scalaVersion := "3.0.1"

enablePlugins(ScalaJSPlugin)

// this states that this is an application with a main method
scalaJSUseMainModuleInitializer := true

lazy val root = project
  .in(file("."))
  .settings(
      name := "ScalaJs Hello World",
      version := "0.1.0",
      // "scalajs-dom" is used in Step 5 in the Discussion
      libraryDependencies +=
          ("org.scala-js" %%% "scalajs-dom" % "1.1.0").cross(CrossVersion.for3Use2_13)
      )
