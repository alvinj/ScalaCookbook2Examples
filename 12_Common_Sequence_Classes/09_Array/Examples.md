# Recipe 12.9, Creating and Updating an Array

Several different ways to define and populate an `Array` ... create an array with initial values:

```scala
val nums = Array(1,2,3)             // Array[Int] = Array(1, 2, 3)
val fruits = Array("a", "b", "c")   // Array[String] = Array(a, b, c)
```

Assign they type manually:

```scala
val a = Array(1, 2)                 // a: Array[Int] = Array(1, 2)
val a = Array[Long](1, 2)           // a: Array[Long] = Array(1, 2)
```

Create an empty array and then add new elements to it while assigning the result to a new variable:

```scala
val a = Array[Int]()         // a: Array[Int] = Array()

// append one element or multiple elements
val b = a :+ 1               // b: Array(1)
val c = b ++ Seq(2,3)        // c: Array(1, 2, 3)

// prepend one element or multiple elements
val d = 10 +: c              // d: Array(10, 1, 2, 3)
val e = Array(8,9) ++: d     // e: Array(8, 9, 10, 1, 2, 3)
```

Define an array with an initial size and type, and then populate it later:

```scala
// create an array with an initial size
val babyNames = new Array[String](1_000)

// somewhere later in the code ...
babyNames(0) = "Alvin"       // Array(Alvin, null, null ...)
babyNames(1) = "Alexander"   // Array(Alvin, Alexander, null ...)
```

Create a null `var` reference to an array, and then assign it later:

```scala
// this makes `fruits` a null value
var fruits: Array[String] = _       // fruits: Array[String] = null

// later in the code ...
fruits = Array("apple", "banana")   // fruits: Array(apple, banana)
```

A handful of other ways to create and populate an `Array`:

```scala
val x = (1 to 5).toArray                // x: Array(1, 2, 3, 4, 5)
val x = Array.range(1, 5)               // x: Array(1, 2, 3, 4)
val x = Array.range(0, 10, 2)           // x: Array(0, 2, 4, 6, 8)
val x = List(1, 2, 3).toArray           // x: Array(1, 2, 3)
"Hello".toArray                         // x: Array[Char] = Array(H,e,l,l,o)
val x = Array.fill(3)("foo")            // x: Array(foo, foo, foo)
val x = Array.tabulate(5)(n => n * n)   // x: Array(0, 1, 4, 9, 16)
```


## Accessing and updating elements

The `Array` is an _indexed_ sequential collection, so accessing and changing values by their index position is straightforward and fast:

```scala
// imagine this is an array with millions or billions of elements
val a = Array('a', 'b', 'c')

val elem0 = a(0)   // elem0: a
val elem1 = a(1)   // elem1: b
```

Update elements by index:

```scala
a(0) = 'A'         // a: Array(A, b, c)
a(1) = 'B'         // a: Array(A, B, c)
```


## Why use Array?

Because the `Array` type has a combination of immutable and mutable characteristics, you may wonder when it should be used ... One reason is performance ... running `b.sortInPlace` with an `Array` of five million randomized `Int` values consistently takes about 500ms:

```scala
import scala.util.Random
val v: Vector[Int] = (1 to 5_000_000).toVector

// create a randomized Array[Int]
val a: Array[Int] = Random.shuffle(v).toArray

a.sortInPlace   // takes ~500ms
```

A randomized `Vector` in the same way and calling its `sorted` method consistently takes over three seconds:

```scala
randomVector.sorted   // takes about 3,100ms
```



