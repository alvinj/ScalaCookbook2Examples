# Recipe 13.5, Transforming One Collection to Another with map


These examples show how to use anonymous functions with `map`:

```scala
val a = Vector(1,2,3)

// add 1 to each element
val b = a.map(_ + 1)        // b: Vector(2, 3, 4)
val b = a.map(e => e + 1)   // b: Vector(2, 3, 4)

// double each element
val b = a.map(_ * 2)        // b: Vector(2, 4, 6)
val b = a.map(e => e * 2)   // b: Vector(2, 4, 6)
```

These examples show how to use a function (or method):

```scala
def plusOne(i: Int) = i + 1
val a = Vector(1, 2, 3)

// three ways to use plusOne with map
val b = a.map(plusOne)           // b: Vector(2, 3, 4)
val b = a.map(plusOne(_))        // b: Vector(2, 3, 4)
val b = a.map(e => plusOne(e))   // b: Vector(2, 3, 4)
```


## Writing a method to work with map

Imagine that you have a list of strings that can potentially be converted to integers:

```scala
val strings = List("1", "2", "hi mom", "4", "yo")
```

You can use `map` to convert that list of strings to a list of integers:

```scala
def lengthOf(s: String): Int = s.length
val x = strings.map(lengthOf)   // x: List(1, 1, 6, 1, 2)
```

Because I really want to convert each string to an integer, what I _really need_ is a function that returns `Option[Int]`:

```scala
import scala.util.Try
def makeInt(s: String): Option[Int] = Try(Integer.parseInt(s)).toOption
```

When given a `"1"` string, that method returns `Some(1)`; and when given a string like `"yo"`, it returns a `None`.

Now you can use `makeInt` with `map` to start converting each string ... a first attempt returns a `List` of `Option[Int]`, i.e., the type `List[Option[Int]]`:

```scala
val intOptions = strings.map(makeInt)

// result:
// val intOptions: List[Option[Int]] = List(Some(1), Some(2), None, Some(4), None)
```

To get the desired answer, flatten that `List[Option[Int]]` into a `List[Int]`:

```scala
val ints = strings.map(makeInt).flatten

// result:
// val ints: List[Int] = List(1, 2, 4)
```


## Discussion

When I first came to Scala my background was in Java, so I initially wrote `for`/`yield` loops:

```scala
val list = List("a", "b", "c")                   // list:  List(a, b, c)

// map
val caps1 = list.map(_.capitalize)               // caps1: List(A, B, C)

// for/yield
val caps2 = for (e <- list) yield e.capitalize   // caps2: List(A, B, C)
```


As a small imperative example, given a list like this:

```scala
val fruits = List("banana", "peach", "lime", "pear", "cherry")
```

an imperative solution to (a) find all of the strings that are more than two characters long, (b) less than six characters long, and then (c) capitalize those remaining strings looks like this:

```scala
val newFruits = for
    f <- fruits
    if f.length < 6
    if f.startsWith("p")
yield
    f.capitalize
```

Conversely, the idiomatic Scala solution is:

```scala
val newFruits = fruits.filter(_.length > 2)
                      .filter(_.startsWith("p"))
                      .map(_.capitalize)
```


### Think of “map” as “transform”

I wished the method was named `transform` instead of `map`:

```scala
fruits.map(_.capitalize)         // what it’s named
fruits.transform(_.capitalize)   // not valid, but what i wish it was named
```

This is because `map` applies your function to each element in the initial list, and transforms those elements into a new list.

(As I explain in my article, https://alvinalexander.com/scala/fp-book/great-fp-terminology-barrier[The “Great FP Terminology Barrier”], the name `map` comes from the field of mathematics.)




