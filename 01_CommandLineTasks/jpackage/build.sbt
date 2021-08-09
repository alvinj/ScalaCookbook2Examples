lazy val root = project
  .in(file("."))
  .settings(
    name := "MySwingApp",
    description := "Lets me use the Scala 3 nightly build",
    version := "0.1.0",
    // scalaVersion := dottyLatestNightlyBuild.get,
    scalaVersion := "3.0.0-RC3",
    useScala3doc := true,
  )

fork in run := true

