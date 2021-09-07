name := "MyProject"
version := "0.1"
scalaVersion := "3.0.1"

// set the main class for the 'sbt run' task
Compile / run / mainClass := Some("com.alvinalexander.Main1")

// set the main class for the 'sbt package' task
Compile / packageBin / mainClass := Some("com.alvinalexander.Main2")


// ------------------------------- //
// a few other settings below here //
// ------------------------------- //

// set the main class for packaging the main jar
// mainClass in (Compile, packageBin) := Some("foo.bar.Goodbye")

// remove the 'run' setting to make the definition less narrow
// Compile / mainClass := Some("foo.bar.Baz")


