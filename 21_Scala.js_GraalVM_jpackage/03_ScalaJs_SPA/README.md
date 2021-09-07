This is the source code for Recipe 21.3 in the Scala Cookbook, “Building Single-Page Applications with Scala.js.”

Bug Report: In the book I use the `fastLinkJS` command, but for the rest of the code I should have used the older `fastOptJS` command. At the time of the book’s publication I thought the two commands were interchangeable, but they aren’t.

So, at the sbt command line prompt, use this command:

```sbt
sbt> fastOptJS
```

That will generate the JavaScript files that are included in the *hello3.html* file.
