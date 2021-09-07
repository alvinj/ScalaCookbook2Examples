# Recipe 15.1, Creating Heterogeneous Lists with Tuples


Create a tuple:

```scala
(1, 1.1)             // (Int, Double)
(1, 1.1, 'a')        // (Int, Double, Char)
(1, 1.1, 'a', "a")   // (Int, Double, Char, String)
```
A method that returns a two-element tuple:

```scala
// return the user name and age
def getUserInfo(): (String, Int) = 
    // do whatever you need to do to get the data and then
    // return it as a tuple
    ("johndoe", 42)
```
Can also declare that return type as a `Tuple2`, like this:

```scala
def getUserInfo(): Tuple2[String, Int] = ("johndoe", 42)
```
With either approach, when you call that method, you create a tuple variable:

```scala
val userInfo = getUserInfo()   // (String, Int)
```
With Scala 2:

```scala
userInfo._1   // "johndoe"
userInfo._2   // 42
```
With Scala 3:

```scala
userInfo(0)   // "johndoe"
userInfo(1)   // 42
```
Another common way:

```scala
val (name, age) = getUserInfo()
name   // "johndoe"
age    // 42
```
Scala 3 tuples are more like lists:

```scala
val t = (1, 2.2, "yo")
t.size      // 3
t.head      // Int = 1
t.tail      // (Double, String) = (2.2,yo)
t.drop(1)   // (Double, String) = (2.2,yo)
```
Concatenate two tuples:

```scala
val t = (1, "a") ++ (3.3, 'd')   // (Int, String, Double, Char) = (1,a,3.3,d)
```
`swap` method:

```scala
val t = (1, 2.2)   // (Int, Double) = (1,2.2)
t.swap             // (Double, Int) = (2.2,1)
```

## Tuples are like lists

You _can_ create lists of heterogeneous elements using implicit or explicit typing:

```scala
val xs = List(1, 2.2, "a", 'b')         // List[Matchable] = List(1, 2.2, a, b)
val xs: List[Any] = List(1, 2.2, "a", 'b')    // List[Any] = List(1, 2.2, a, b)
```
However, you lose the type details. By contrast, a tuple keeps those details:

```scala
(1, 2.2, "a", 'b')   // (Int, Double, String, Char) = (1,2.2,a,b)
```
In Scala 3 you can also use this `*:` syntax:

```scala
1 *: "a" *: 2.2 *: EmptyTuple   // (Int, String, Double) = (1,a,2.2)

// that’s like creating a List:
1 :: 2 :: Nil   // List[Int] = List(1, 2)
```
You’ll see the `*:` syntax elsewhere:

```scala
val z = (1,2).zip("a", "b")

// result:
val z: (Int, String) *: 
  scala.Tuple.Zip[Int *: scala.Tuple$package.EmptyTuple.type, String *:
  scala.Tuple$package.EmptyTuple.type] = ((1,a),(2,b))

z
// result:
val res0: (Int, String) *: (Int, String) *: EmptyTuple = ((1,a),(2,b))
```

## Tuples and classes

Tuples ...a replacement for a class:

```scala
// [1] create a case class and instance of it
case class Stock(symbol: String, price: Double)
val aapl = Stock("AAPL", 123.45)

// [2] create a tuple from the case class
val t = Tuple.fromProductTyped(aapl)   // (String, Double) = (AAPL,123.45)
```
Write generic methods that accept _any_ `(String, Double)` tuple:

```scala
def handleTuple(t: (String, Double)): Unit =
    println(s"String: ${t(0)}, Double: ${t(1)}")
```

## Tuples and maps

Two-element tuples used to create maps:

```scala
val m = Map(
    (1, "a"),
    (2, "b")
)
```
A two-element tuple using this arrow syntax:

```scala
1 -> "a"   // (Int, String) = (1,a)
```
This is the same “arrow” syntax that’s typically used when creating a map:

```scala
val m = Map(
    1 -> "a",
    2 -> "b"
)
```



