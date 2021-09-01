name := "PlayJsonWithoutPlay"
version := "0.1"
scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
    "com.typesafe.play" %% "play-json" % "2.9.1",
    "com.softwaremill.sttp.client3" %% "core" % "3.2.3"
    // "com.softwaremill.sttp.client3" %% "core" % "3.0.0-RC7"
)

// see https://tpolecat.github.io/2017/04/25/scalac-flags.html for scalacOptions descriptions
scalacOptions ++= Seq(
    "-deprecation",     //emit warning and location for usages of deprecated APIs
    "-unchecked",       //enable additional warnings where generated code depends on assumptions
    "-explaintypes",    //explain type errors in more detail
    "-Ywarn-dead-code", //warn when dead code is identified
    "-Xfatal-warnings"  //fail the compilation if there are any warnings
)
    
