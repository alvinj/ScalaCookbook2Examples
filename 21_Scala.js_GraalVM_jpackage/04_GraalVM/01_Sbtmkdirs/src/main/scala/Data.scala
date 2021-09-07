package sbtmkdirs

object Data {

    val gitignoreString = """
        |bin/
        |target/
        |project/target/
        |build/
        |.bloop
        |.metals
        |.cache
        |.cache-main
        |.classpath
        |.history
        |.project
        |.scala_dependencies
        |.settings
        |.worksheet
        |.DS_Store
        |*.class
        |*.log
        |*.iml
        |*.ipr
        |*.iws
        |.idea
        """.stripMargin

    def readmeData(projectName: String) =
        s"""|# ${projectName}
            |
        """.stripMargin

    def buildDotSbtData(projectName: String) =
    s"""|name := "$projectName"
        |version := "0.1"
        |scalaVersion := "2.13.2"
        |
        |libraryDependencies ++= Seq(
        |    "org.scalactic" %% "scalactic" % "3.2.0",
        |    "org.scalatest" %% "scalatest" % "3.2.0" % "test"
        |)
        |
        |// see https://tpolecat.github.io/2017/04/25/scalac-flags.html for scalacOptions descriptions
        |scalacOptions ++= Seq(
        |    "-deprecation",     //emit warning and location for usages of deprecated APIs
        |    "-unchecked",       //enable additional warnings where generated code depends on assumptions
        |    "-explaintypes",    //explain type errors in more detail
        |    "-Ywarn-dead-code", //warn when dead code is identified
        |    "-Xfatal-warnings"  //fail the compilation if there are any warnings
        |)
    """.stripMargin
        
}


