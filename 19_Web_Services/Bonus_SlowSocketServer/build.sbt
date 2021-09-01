name := "ScalaSlowSocketServer"
version := "0.1"
scalaVersion := "3.0.1"

// this is needed so you can press ctrl-c inside sbt to stop
// the server, but not kill your sbt session
fork := true

scalacOptions ++= Seq(
    "-deprecation",
    "-explain",
    "-explain-types",
    "-new-syntax",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xmigration"
)