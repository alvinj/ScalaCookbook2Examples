# Recipe 24.6, Using Scala’s Error-Handling Types (Option, Try, and Either)



## Extracting the value from an Option

Two ways to define a `makeInt` function:

```scala
import scala.util.control.Exception.allCatch
def makeInt(s: String): Option[Int] = allCatch.opt(s.trim.toInt)

import scala.util.{Try, Success, Failure}
def makeInt(s: String): Option[Int] = Try(s.trim.toInt).toOption
```

Return a value from a `match` expression:

```scala
val result = makeInt(aString) match
    case Some(i) => i
    case None => 0
```

Use a `match` expression to produce a side effect:

```scala
makeInt(aString) match
    case Some(i) => println(i)
    case None => println(0)
```

The `foreach` method:

```scala
makeInt(aString).foreach{ i =>
    println(s"Got an int: $i")
}
```

Use `getOrElse`:

```scala
val x = makeInt("1").getOrElse(0)   // 1
val y = makeInt("A").getOrElse(0)   // 0
```



## Using Option with Scala collections

`Option` is often used in the Scala collections:

```scala
val possibleNums = List("1", "2", "foo", "3", "bar")
```

Passing `makeInt` into `map`:

```scala
possibleNums.map(makeInt)

// result:
res0: List[Option[Int]] = List(Some(1), Some(2), None, Some(3), None)
```

Convert this `List[Option[Int]]` values into a `List[Int]` by adding `flatten`:

```scala
val a = possibleNums.map(makeInt).flatten   // a: List[Int] = List(1, 2, 3)
```

This is the same as calling `flatMap`:

```scala
val a = possibleNums.flatMap(makeInt)   // a: List[Int] = List(1, 2, 3)
```

`collect` also works:

```scala
possibleNums.map(makeInt).collect{case Some(i) => i}

// result:
res0: List[Int] = List(1, 2, 3)
```


## scala.util.control.Exception.allCatch

Another way to use `Option`, `Try` and `Either` values:

```scala
import scala.util.control.Exception.allCatch
import scala.io.Source

def readTextFile(f: String): Option[List[String]] =
    allCatch.opt(Source.fromFile(f).getLines.toList)
```



## Use Try or Either when you want access to the failure reason

When you want to use the `Option`/`Some`/`None` approach, but also want to write a method that returns error information in the failure case, there are two similar sets of error-handling classes:

- 
- 

In this section I’ll demonstrate the `Try`/`Success`/`Failure` classes.

`Try` is similar to `Option`, but returns exception information in a `Failure` object, as opposed to `None`, which doesn’t give you this information. The result of a computation wrapped in a `Try` will be one of its subclasses:

- `Success` (which is like `Some`)
- `Failure` (which is similar to `None`)

If the computation succeeds, a `Success` instance is returned and contains the desired result; if an exception was thrown, a `Failure` is returned, and the `Failure` holds information about what failed.


### `Try`, `Success`, and `Failure`

First import the classes and create a test function:

```scala
import scala.util.{Try,Success,Failure}
def divideXByY(x: Int, y: Int): Try[Int] = Try(x/y)
```

The REPL demonstrates how the `Success` and `Failure` cases work:

```scala
divideXByY(1,1)   // scala.util.Try[Int] = Success(1)
divideXByY(1,0)   // scala.util.Try[Int] = Failure(java.lang.ArithmeticException: / by zero)
```

One way to access the information in `Failure` is with a `match` expression:

```scala
divideXByY(1, 1) match
    case Success(i) => println(s"Success, value is: $i")
    case Failure(s) => println(s"Failed, message is: $s")
```

`foreach` works well for side effects like printing:

```scala
divideXByY(1, 1).foreach(println)   // prints 1
divideXByY(1, 0).foreach(println)   // no output is printed
```

If you don’t care about the error message and just want a result, use `getOrElse`:

```scala
val x = divideXByY(1, 1).getOrElse(0)   // x: 1
val y = divideXByY(1, 0).getOrElse(0)   // y: 0
```

Chain operations together:

```scala
// 'x' and 'y' are String values
val z = for
    a <- Try(x.toInt)
    b <- Try(y.toInt)
yield
    a * b

val answer = z.getOrElse(0) * 2
```



## `Either`, `Left`, and `Right`

Use the `Either`, `Left`, and `Right` classes:

```scala
// 1st approach
import scala.util.control.Exception.allCatch
def divideXByY(x: Int, y: Int): Either[Throwable, Int] = allCatch.either(x/y)

// 2nd approach
import scala.util.{Try,Success,Failure}
def divideXByY(x: Int, y: Int): Either[Throwable, Int] = Try(x/y).toEither
```

One way to write the `makeInt` method using `Either`:

```scala
def makeInt(s: String): Either[String, Int] = 
    try
        Right(s.trim.toInt)
    catch
        case e: Exception => Left(e.getMessage)
```

Two possible results from calling `makeInt`:

```scala
makeInt("1")   // Right(1)
makeInt("a")   // Left(For input string: "a")
```

`Either` is right-biased:

```scala
makeInt("1").map(_ * 2)   // Right(2)
makeInt("a").map(_ * 2)   // Left(For input string: "a")
```

Because of this, `Either` works well in `for` expressions:

```scala
val x = 
    for
        a <- makeInt("1")
        b <- makeInt("2")
    yield
        a + b

// result: x == Right(3)
```

`match` expressions work just like `Option` and `Try`:

```scala
makeInt(aString) match
    case Right(x) => println(s"Success, x = $x")
    case Left(s)  => println(s"Failure, message = $s")
```






