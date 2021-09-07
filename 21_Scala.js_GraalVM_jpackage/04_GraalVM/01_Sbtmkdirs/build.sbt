lazy val sbtmkdirs = (project in file("."))
    .enablePlugins(NativeImagePlugin)
    .settings(
        name := "Sbtmkdirs",
        version := "0.2",
        scalaVersion := "3.0.1",
        Compile / mainClass := Some("sbtmkdirs.Sbtmkdirs")
    )

scalacOptions ++= Seq(
    "-deprecation",
    "-explain",
    "-explain-types",
    "-new-syntax",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xmigration"
)
