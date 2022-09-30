import sbt.Compile
import sbt.Keys.{ libraryDependencies, scalacOptions }

import scala.collection.Seq

ThisBuild / organization := "com.alvinalexander"

name := "ScalaCookbook2Examples"

ThisBuild / version := "1.0.0"

ThisBuild / scalaVersion := "3.2.0"

lazy val ScalaCookbook2Examples = (project in file("."))
  .aggregate(
    `chapter1`,
    `chapter2`,
    `chapter3`,
    `chapter4`,
    `chapter5`,
    `chapter6`,
    `chapter7`,
    `chapter8`,
    `chapter9`,
    `chapter10`,
    `chapter11`,
    `chapter12`,
    `chapter13`,
    `chapter14`,
    `chapter15`,
    `chapter16`,
    `chapter17-4`,
    `chapter17-10`,
    `chapter17-11`,
    `chapter17-12`,
    `chapter18-akka`,
    `chapter18-future`,
    `chapter19`,
    `chapter19-1`,
    `chapter19-2`,
    `chapter19-3`,
    `chapter19-4`,
    `chapter19-5`,
    `chapter19-6`,
    `chapter19-7`,
    `chapter19-8`,
    `chapter20`,
    `chapter21`,
    `chapter21-1`,
    `chapter21-2`,
    `chapter21-3`,
    `chapter21-4-1`,
    `chapter21-4-2`,
    `chapter21-5`,
    `chapter22`,
    `chapter23`,
    `chapter24`,
    `SimpleTest`
  )

lazy val common =
  scalacOptions ++= Seq(
    "-deprecation",     // emit warning and location for usages of deprecated APIs
    "-explain",         // explain errors in more detail
    "-explain-types",   // explain type errors in more detail
    "-feature",         // emit warning and location for usages of features that should be imported explicitly
    "-indent",          // allow significant indentation.
    "-new-syntax",      // require `then` and `do` in control expressions.
    "-print-lines",     // show source code line numbers.
    "-unchecked",       // enable additional warnings where generated code depends on assumptions
    "-Ykind-projector", // allow `*` as wildcard to be compatible with kind projector
    "-Xfatal-warnings", // fail the compilation if there are any warnings
    "-Xmigration"       // warn about constructs whose behavior may have changed since version
  )

lazy val `chapter1` = (project in file("01_CommandLineTasks"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter2` = (project in file("02_Strings"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter3` = (project in file("03_NumbersAndDates"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter4` = (project in file("04_ControlStructures"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    common
  )
  .dependsOn(`SimpleTest`)

lazy val `chapter5` = (project in file("05_Classes"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    common
  )
  .dependsOn(`SimpleTest`)

lazy val `chapter6` = (project in file("06_TraitsAndEnums"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    common
  )
  .dependsOn(`SimpleTest`)

lazy val `chapter7` = (project in file("07_Objects"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter8` = (project in file("08_Methods"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    common
  )
  .dependsOn(`SimpleTest`)

lazy val `chapter9` = (project in file("09_Packaging"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter10` = (project in file("10_FP"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter11` = (project in file("11_Collections_Intro"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter12` = (project in file("12_Common_Sequence_Classes"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter13` = (project in file("13_Common_Sequence_Methods"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter14` = (project in file("14_Maps"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter15` = (project in file("15_Tuple_Range_Set_Stack_Queue"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter16` = (project in file("./16_Files_Processes"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    common
  )
  .dependsOn(`SimpleTest`)

lazy val `chapter17-4` = (project in file("17_sbt/04_compiling_running"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name := "CompilingRunningPackaging",
    scalacOptions ++= Seq(
      "-deprecation",
      "-explain",
      "-explain-types",
      "-new-syntax",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xmigration"
    )
  )

lazy val `chapter17-10` = (project in file("17_sbt/10_MainMethods"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name := "MyProject",
// set the main class for the 'sbt run' task
    Compile / run / mainClass := Some("com.alvinalexander.Main1"),
// set the main class for the 'sbt package' task
    Compile / packageBin / mainClass := Some("com.alvinalexander.Main2")
// ------------------------------- //
// a few other settings below here //
// ------------------------------- //

// set the main class for packaging the main jar
// mainClass in (Compile, packageBin) := Some("foo.bar.Goodbye")

// remove the 'run' setting to make the definition less narrow
// Compile / mainClass := Some("foo.bar.Baz")
  )

lazy val `chapter17-11` = (project in file("17_sbt/11_Assembly"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name := "MyProject",
    version := "0.1.0",
    assembly / mainClass := Some("com.alvinalexander.myproject.Foo"),
    assembly / assemblyJarName := "MyApp.jar",
    assembly / test := {}
  )


lazy val `chapter17-12` = (project in file("17_sbt/12_Publishing"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name := "StringUtils",
    // for the 'publish' task; tells sbt to write its output to the
    // "out" subdirectory
    publishTo := Some(Resolver.file("file", new File("./out")))
  )

lazy val akkaVersion = "2.6.4"

lazy val `chapter18-akka` = (project in file("18_Concurrency_Futures/Akka_Examples"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name := "AkkaExamples",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed"         % akkaVersion,
      "ch.qos.logback"     % "logback-classic"          % "1.2.3",
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
      "org.scalatest"     %% "scalatest"                % "3.1.0"     % Test
    ),
    scalaVersion := "2.13.5" // 没有指定的默认是3.2.0
  )
  .dependsOn(`SimpleTest`)

lazy val `chapter18-future` = (project in file("18_Concurrency_Futures/Future_Examples"))
  .enablePlugins(ScalafmtPlugin)
  .settings(common, name := "Concurrency_Futures")
  .dependsOn(`SimpleTest`)

lazy val `chapter19` = (project in file("19_Web_Services"))
  .enablePlugins(ScalafmtPlugin)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.alvinalexander.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.alvinalexander.binders._"
lazy val `chapter19-1` = (project in file("19_Web_Services/01_Creating_Play_Project/hello-world"))
  .enablePlugins(ScalafmtPlugin, PlayScala)
  .settings(
    scalaVersion := "2.13.6",
    name         := """hello-world""",
    libraryDependencies += guice,
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
  )

lazy val `chapter19-2` = (project in file("19_Web_Services/02_Creating_New_Play_Endpoint/hello-world"))
  .enablePlugins(ScalafmtPlugin, PlayScala)
  .settings(
    name         := """hello-world""",
    scalaVersion := "2.13.6",
    libraryDependencies += guice,
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
  )

lazy val `chapter19-3` = (project in file("19_Web_Services/03_Returning_JSON_from_GET/hello-world"))
  .enablePlugins(ScalafmtPlugin, PlayScala)
  .settings(
    name         := """hello-world""",
    scalaVersion := "2.13.6",
    libraryDependencies += guice,
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
  )

lazy val `chapter19-4` = (project in file("19_Web_Services/04_Serializing_Object_to_JSON"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name         := "PlayJsonWithoutPlay",
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq(
      "com.typesafe.play"             %% "play-json" % "2.9.1",
      "com.softwaremill.sttp.client3" %% "core"      % "3.2.3"
      // "com.softwaremill.sttp.client3" %% "core" % "3.0.0-RC7"
    ),

    // see https://tpolecat.github.io/2017/04/25/scalac-flags.html for scalacOptions descriptions
    scalacOptions ++= Seq(
      "-deprecation",     // emit warning and location for usages of deprecated APIs
      "-unchecked",       // enable additional warnings where generated code depends on assumptions
      "-explaintypes",    // explain type errors in more detail
      "-Ywarn-dead-code", // warn when dead code is identified
      "-Xfatal-warnings"  // fail the compilation if there are any warnings
    )
  )

lazy val `chapter19-5` = (project in file("19_Web_Services/05_Deserializing_JSON_to_Object"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name         := "PlayJsonWithoutPlay",
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-json" % "2.9.1"
    ),
    // see https://tpolecat.github.io/2017/04/25/scalac-flags.html for scalacOptions descriptions
    scalacOptions ++= Seq(
      "-deprecation",     // emit warning and location for usages of deprecated APIs
      "-unchecked",       // enable additional warnings where generated code depends on assumptions
      "-explaintypes",    // explain type errors in more detail
      "-Ywarn-dead-code", // warn when dead code is identified
      "-Xfatal-warnings"  // fail the compilation if there are any warnings
    )
  )

lazy val `chapter19-6` = (project in file("19_Web_Services/06_Using_PlayJson_Without_Play"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name         := "PlayJsonWithoutPlay",
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq(
      "com.typesafe.play"             %% "play-json" % "2.9.1",
      "com.softwaremill.sttp.client3" %% "core"      % "3.2.3"
      // "com.softwaremill.sttp.client3" %% "core" % "3.0.0-RC7"
    ),

    // see https://tpolecat.github.io/2017/04/25/scalac-flags.html for scalacOptions descriptions
    scalacOptions ++= Seq(
      "-deprecation",     // emit warning and location for usages of deprecated APIs
      "-unchecked",       // enable additional warnings where generated code depends on assumptions
      "-explaintypes",    // explain type errors in more detail
      "-Ywarn-dead-code", // warn when dead code is identified
      "-Xfatal-warnings"  // fail the compilation if there are any warnings
    )
  )

lazy val `chapter19-7` = (project in file("19_Web_Services/07_Using_sttp_HTTP_Client"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name         := "Sttp",
    scalaVersion := "3.0.0",
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client3" %% "core" % "3.3.13"
    )
  )

lazy val `chapter19-8` = (project in file("19_Web_Services/Bonus_SlowSocketServer"))
  .enablePlugins(ScalafmtPlugin)
  .settings(
    name := "ScalaSlowSocketServer",
    fork := true,
    scalacOptions ++= Seq(
      "-deprecation",
      "-explain",
      "-explain-types",
      "-new-syntax",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xmigration"
    )
  )

lazy val `chapter20` = (project in file("20_Spark"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter21` = (project in file("21_Scala.js_GraalVM_jpackage"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter21-1` = (project in file("21_Scala.js_GraalVM_jpackage/01_ScalaJs_GettingStarted"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)
  .settings(
    name                            := "ScalaJs Hello World",
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies +=
      ("org.scala-js" %%% "scalajs-dom" % "1.1.0").cross(CrossVersion.for3Use2_13)
  )
  .enablePlugins(ScalaJSPlugin)

lazy val `chapter21-2` = (project in file("21_Scala.js_GraalVM_jpackage/02_ScalaJs_Events"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)
  .settings(
    name                            := "ScalaJs2",
    scalaJSUseMainModuleInitializer := true,
    Compile / mainClass             := Some("hello.hello2"),
    libraryDependencies ++= Seq(
      ("org.scala-js" %%% "scalajs-dom"   % "1.1.0").cross(CrossVersion.for3Use2_13),
      ("org.querki"   %%% "jquery-facade" % "2.0").cross(CrossVersion.for3Use2_13)
    ),
    jsDependencies += "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js"
  )
  .enablePlugins(ScalaJSPlugin, JSDependenciesPlugin)

lazy val `chapter21-3` = (project in file("21_Scala.js_GraalVM_jpackage/03_ScalaJs_SPA"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)
  .settings(
    name                            := "ScalaJs3",
    scalaJSUseMainModuleInitializer := true,
    Compile / mainClass             := Some("hello.Hello3"),
    libraryDependencies ++= Seq(
      ("org.scala-js" %%% "scalajs-dom"   % "1.1.0").cross(CrossVersion.for3Use2_13),
      ("org.querki"   %%% "jquery-facade" % "2.0").cross(CrossVersion.for3Use2_13),
      ("com.lihaoyi"  %%% "scalatags"     % "0.9.4").cross(CrossVersion.for3Use2_13)
    ),
    jsDependencies += "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js"
  )
  .enablePlugins(ScalaJSPlugin, JSDependenciesPlugin)

lazy val `chapter21-4-1` = (project in file("21_Scala.js_GraalVM_jpackage/04_GraalVM/01_Sbtmkdirs"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)
  .settings(
    name                := "Sbtmkdirs",
    Compile / mainClass := Some("sbtmkdirs.Sbtmkdirs"),
    scalacOptions ++= Seq(
      "-deprecation",
      "-explain",
      "-explain-types",
      "-new-syntax",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xmigration"
    )
  )
  .enablePlugins(NativeImagePlugin)

lazy val `chapter21-4-2` = (project in file("21_Scala.js_GraalVM_jpackage/04_GraalVM/02_Bonus_HttpClient"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)
  .settings(
    name := "http_client",
    scalacOptions ++= Seq(
      "-deprecation",
      "-explain",
      "-explain-types",
      "-new-syntax",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xmigration"
    ),
    Compile / mainClass := Some("foo.HttpClient"),
    nativeImageOptions ++=
      Seq(
        "-H:EnableURLProtocols=http",
        "-H:EnableURLProtocols=https",
        "--enable-url-protocols=http,https",
        "--enable-https",
        "--enable-http"
      )
  )
  .enablePlugins(NativeImagePlugin)

lazy val `chapter21-5` = (project in file("21_Scala.js_GraalVM_jpackage/05_jpackage"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)
  .settings(
    name                 := "MySwingApp",
    Compile / run / fork := true
  )

lazy val `chapter22` = (project in file("22_Java_Integration"))
  .enablePlugins(ScalafmtPlugin)
  .dependsOn(`SimpleTest`)

lazy val `chapter23` = (project in file("23_Types"))
  .dependsOn(`SimpleTest`)
  .enablePlugins(ScalafmtPlugin)

lazy val `chapter24` = (project in file("24_Best_Practices"))
  .dependsOn(`SimpleTest`)
  .enablePlugins(ScalafmtPlugin)

lazy val `SimpleTest` = (project in file("SimpleTest"))
  .enablePlugins(ScalafmtPlugin)
  .settings(common)