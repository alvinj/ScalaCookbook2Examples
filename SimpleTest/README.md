# SimpleTest

This is an extremely simple “testing” framework that I used while writing
the [Scala Cookbook (2nd Edition)](https://amzn.to/3du1pMR).

Basically what happened is that I needed a framework to test with,
and the frameworks that I normally use (like ScalaTest) were being 
rewritten, so sometimes they were available for a certain version 
of Dotty, but very often they weren’t.

After trying some other testing frameworks, I decided that what I really
wanted for the purpose of the book’s examples was to have my tests in my
`@main` methods, so I created this very little library.

To call this a “framework” is a bit of an inside joke. It’s really just
about 100 lines of code in one file that give me something more than `assert`,
and less than a full-blown testing framework with other required dependencies
(that may or may not have been available in 2020 through early 2021).



## Usage

Currently you have to build the project with `sbt package` and
then put the resulting jar file in your _lib_ directory. At some
point I’ll work on packaging this a bit more.

Once you have the needed jar file, see the 
[src/main/scala/tests/Tests.scala](Tests.scala) file for
up-to-date examples, but the basic usage looks like this:

```scala
import com.alvinalexander.simpletest.SimpleTest._

@main def tests =

    // use `True` to assert that an expression is true
    True(1 == 1,  "1 == 1 (expecting green)")
    True(1 == 2,  "1 == 2 (expecting red)")

    // use `False` to assert that an expression is false
    False(1 == 2, "1 == 2 (expecting green)")
    False(1 == 1, "1 == 1 (expecting red)")

    // use `Equals` to assert that two objects are `==`
    Equals(1, 1,  "i expect green")
    Equals(1, 2,  "i expect red here")

    // in case you want to note tests that you intend to run
    Todo("don’t forget to test 2 == 3")
    
    // numbering is too much work, just let the object 
    // keep track of the test numbers
    True(1 == 1)
    False(1 == 2)
    Equals(1, 1)
```


## The source code

The actual source code for the test methods (`True`, `False`, etc.)
is in the
[src/main/scala/com.alvinalexander.simpletest/SimpleTest.scala](SimpleTest.scala)
file.

Somewhat ironically, I didn’t take the time to write any tests
for these. I started to look into integrating this code with sbt so
it could be called with `sbt run`, but somewhere around this time
I decided that I would rather just have my tests in my `@main`
methods.



## Versions

- 0.3.0
    - Now using `True`, `False`, `Equals`, and `Todo` for the test names
    - I like these names better than the alternatives I tried (`_true`,
      `true_?`, `isTrue`, etc.)


## TODO

- refactor the code more
    - can probably use varargs for the “description” parameters




