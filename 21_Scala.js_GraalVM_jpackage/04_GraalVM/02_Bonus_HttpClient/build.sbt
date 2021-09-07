lazy val sbtmkdirs = (project in file("."))
    .enablePlugins(NativeImagePlugin)
    .settings(
        name := "http_client",
        version := "0.1",
        scalaVersion := "3.0.1",
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

scalacOptions ++= Seq(
    "-deprecation",
    "-explain",
    "-explain-types",
    "-new-syntax",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xmigration"
)
