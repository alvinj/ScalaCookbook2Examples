Here are a few links from the sbt website that provide examples of `Compile / run` settings:

* https://www.scala-sbt.org/1.x/docs/Basic-Def-Examples.html
* https://www.scala-sbt.org/1.x/docs/Forking.html
* https://www.scala-sbt.org/1.x/docs/Basic-Def-Examples.html

From that last link:

````
// set the main class for packaging the main jar
// 'run' will still auto-detect and prompt
// change Compile to Test to set it for the test jar
Compile / packageBin / mainClass := Some("myproject.MyMain"),

// set the main class for the main 'run' task
// change Compile to Test to set it for 'test:run'
Compile / run / mainClass := Some("myproject.MyMain"),
````

