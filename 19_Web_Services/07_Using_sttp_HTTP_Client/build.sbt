lazy val root = project
    .in(file("."))
    .settings(
        name := "Sttp",
        version := "0.1.0",
        scalaVersion := "3.0.0",
        libraryDependencies ++= Seq(
            "com.softwaremill.sttp.client3" %% "core" % "3.3.13"
        )
    )

