// this is the "Scala 2.13 cross-building" 
// example on the top of p. 506

name := "MyCatsProject"
version := "0.1"
scalaVersion := "3.0.0"

// When you want to use a Scala 2.13 dependency in a 
// Scala 3 build.sbt file, use this `cross(CrossVersion.for3Use2_13)` 
// syntax:

libraryDependencies ++= Seq(
  ("org.scala-js" %%% "scalajs-dom" % "1.1.0").cross(CrossVersion.for3Use2_13),
  ("org.querki" %%% "jquery-facade" % "2.0").cross(CrossVersion.for3Use2_13)
)

