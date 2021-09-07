# Recipe 15.2, Creating Ranges


## Creating a range with “to”

Create a range is with `to`:

```scala
val r = 1 to 5

// r: scala.collection.immutable.Range.Inclusive = Range 1 to 5
```

Set an optional _step_ with `by`:

```scala
val r = 1 to 10 by 2   // will contain Range(1, 3, 5, 7, 9)
val r = 1 to 10 by 3   // will contain Range(1, 4, 7, 10)
```

Ranges in `for` loops:

```scala
for i <- 1 to 3 do println(i)

// result:
1
2
3
```

Ranges are created lazily, as shown in the REPL:

```scala
scala> 1 to 10 by 2
val res0: Range = inexact Range 1 to 10 by 2
```

To verify the actual contents of a range, you can force it to a sequence with methods like `toList`, `toVector`, etc.:

```scala
(1 to 10 by 2).toList

// result:
val res1: List[Int] = List(1, 3, 5, 7, 9)
```


## Creating a range with “until”

Create a range with `until`:

```scala
for i <- 1 until 3 do println(i)

// result:
1
2
```

`until` vs. `to`:

```scala
(1 to 3).toVector          // Vector(1, 2, 3)
(1 until 3).toVector       // Vector(1, 2)

(1 to 10 by 3).toList      // List(1, 4, 7, 10)
(1 until 10 by 3).toList   // List(1, 4, 7)
```


## Populating sequences

Convert a `Range` to other sequences:

```scala
(1 to 5).toList         // List[Int] = List(1, 2, 3, 4, 5)
(1 until 5).toVector    // Vector[Int] = Vector(1, 2, 3, 4)
(1 to 5).toBuffer       // mutable.Buffer[Int] = ArrayBuffer(1, 2, 3, 4, 5)

(1 to 5).toSeq          // immutable.Range = Range 1 to 5
(1 to 5).toSet          // Set[Int] = Set(5, 1, 2, 3, 4)
(1 to 5).to(LazyList)   // LazyList[Int] = LazyList(<not computed>)
```


## Discussion

When you create a `Range` ... some REPL examples:


```scala
scala> *val r = 1 to 5*
r: scala.collection.immutable.Range.Inclusive = Range 1 to 5
                                                `````````

scala> *1 to 999_999_999*
res0: scala.collection.immutable.Range.Inclusive = Range 1 to 999999999

scala> *(1 to 999_999_999).toVector*
java.lang.OutOfMemoryError: GC overhead limit exceeded

scala> *(1 to 999_999_999).to(LazyList)*
val res1: LazyList[Int] = LazyList(<not computed>)

scala> *LazyList.range(1, 999_999_999)*
res1: scala.collection.immutable.LazyList[Int] = LazyList(<not computed>)
```


## Using the range method on sequences

Create specific sequence types with their `range` methods:

```scala
Vector.range(1, 3)        // Vector(1, 2)
Array.range(1, 6, 2)      // Array(1, 3, 5)
List.range(1, 6, 2)       // List(1, 3, 5)

import collection.mutable.ArrayBuffer
ArrayBuffer.range(1, 3)   // ArrayBuffer(1, 2)
```

The third parameter is the step size:

```scala
List.range(1, 10)      // List(1, 2, 3, 4, 5, 6, 7, 8, 9)
List.range(1, 10, 2)   // List(1, 3, 5, 7, 9)
List.range(1, 10, 3)   // List(1, 4, 7)
List.range(1, 10, 4)   // List(1, 5, 9)
```


## Char ranges

Use the same approaches with `Char` values:

```scala
// 'to' and 'until' are lazy
'a' to 'e'                  // NumericRange a to e
'a' until 'e'               // NumericRange a until e

// 'to' is inclusive, 'until' is not
('a' to 'e').toList         // List(a, b, c, d, e)
('a' until 'e').toList      // List(a, b, c, d)

// you can also use a step with Char
('a' to 'e' by 2).toList    // List(a, c, e)
('a' to 'e').by(2).toList   // List(a, c, e)
```

You can see that `to`, `by`, and `until` are methods:

```scala
(1 to 10 by 3).toVector      // Vector(1, 4, 7, 10)
(1 to 10).by(3).toVector     // Vector(1, 4, 7, 10)
1.to(10).by(3).toVector      // Vector(1, 4, 7, 10)
1.until(10).by(3).toVector   // Vector(1, 4, 7)
```



## More ways to populate collections with ranges

By using the `map` with a `Range`:

```scala
val x = (1 to 5).map(_ * 2.0)

// result:
val x: IndexedSeq[Double] = Vector(2.0, 4.0, 6.0, 8.0, 10.0)
```

Can also return a sequence of `Tuple2` elements:

```scala
val x = (1 to 5).map(e => (e,e))

// result:
val x: IndexedSeq[(Int, Int)] = Vector((1,1), (2,2), (3,3), (4,4), (5,5))
```

Easily converts to a `Map`:

```scala
val map = (1 to 5).map(e => (e,e)).toMap

// result:
val map: Map[Int, Int] = HashMap(5 -> 5, 1 -> 1, 2 -> 2, 3 -> 3, 4 -> 4)
```

Can also use `tabulate` and `fill`:

```scala
List.tabulate(3)(_ + 1)   // List(1, 2, 3)
List.tabulate(3)(_ * 2)   // List(0, 2, 4)
List.tabulate(4)(_ * 2)   // List(0, 2, 4, 6)
Vector.fill(3)("a")       // Vector(a, a, a)
```




