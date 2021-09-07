ThisBuild / scalaVersion := "3.0.1"

enablePlugins(ScalaJSPlugin)

// this states that this is an application with a main method
scalaJSUseMainModuleInitializer := true

Compile/mainClass := Some("hello.Hello3")

lazy val root = project
  .in(file("."))
  .settings(
      name := "ScalaJs3",
      version := "0.1",
      libraryDependencies ++= Seq(
          ("org.scala-js" %%% "scalajs-dom" % "1.1.0").cross(CrossVersion.for3Use2_13),
          ("org.querki" %%% "jquery-facade" % "2.0").cross(CrossVersion.for3Use2_13),
          ("com.lihaoyi" %%% "scalatags" % "0.9.4").cross(CrossVersion.for3Use2_13)
      ),
  )

  // this includes jquery with webjars
  // see: https://github.com/scala-js/jsdependencies
  // you need to update project/plugins.sbt for this to work
  enablePlugins(JSDependenciesPlugin)
  jsDependencies += "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js"
  
