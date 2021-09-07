lazy val root = (project in file("."))
    .settings(
        name := "StringUtils",
        version := "1.0",
        scalaVersion := "3.0.0"
    )

// for the 'publish' task; tells sbt to write its output to the
// "out" subdirectory
publishTo := Some(Resolver.file("file", new File("./out")))
