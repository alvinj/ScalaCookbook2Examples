# Recipe 24.4, Using Match Expressions and Pattern Matching



## Replacement for the Java switch statement and unwieldy if/then statements

`match` can be used like a Java `switch` statement:

```scala
val month = i match
    case 1  => "January"
    // the rest of the months here ...
    case 12 => "December"
    case _  => "Invalid month"   // the default, catch-all case
```

Replace unwieldy `if`/`then`/`else` statements:

```scala
val evenOrOdd = i match
    case 1 | 3 | 5 | 7 | 9 => "odd"
    case 2 | 4 | 6 | 8 | 10 => "even"
```



## As the body of a function or method

Use `match` as the body of your functions:

```scala
def isTrue(a: Matchable) = a match
    case false | 0 | "" => false
    case _ => true
```



## Use with Option variables

Match expressions with `Option`/`Some`/`None`:

```scala
import scala.util.control.Exception.allCatch
def makeInt(s: String): Option[Int] = allCatch.opt(s.trim.toInt)
```

Handle the result from `makeInt` with `match`:

```scala
makeInt(aString) match
    case Some(i) => println(i)
    case None => println("Error: Could not convert String to Int.")
```

You can also use the `fold` method on `Option` values to handle situations like this:

```scala
// first example
makeInt(aString).fold(println("Error..."))(println)

// second example
makeInt(aString).fold(false)(_ > 0)
```


## In try/catch expressions

Case statements are also used in `try`/`catch` expressions:

```scala
def readTextFile(filename: String): Option[List[String]] =
    try
        Some(Source.fromFile(filename).getLines.toList)
    catch
        case ioe: IOException =>
            None
        case fnf: FileNotFoundException =>
            None
```






