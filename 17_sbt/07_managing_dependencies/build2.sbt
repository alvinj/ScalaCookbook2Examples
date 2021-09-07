// this is the example on the top of p. 506

name := "MyCatsProject"
version := "0.1"
scalaVersion := "3.0.0"

// multiple dependencies
libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-core" % "2.6.0",
    "org.typelevel" %% "cats-effect" % "3.1.0"
)

