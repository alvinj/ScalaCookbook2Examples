# Recipe 13.7, Using filter to Filter a Collection


To filter a sequence:

- Use the `filter` method on immutable collections
- Use `filterInPlace` on mutable collections


## Use filter on immutable collections

How to use `filter` with a list of integers and two different algorithms:

```scala
val a = List.range(1, 10)          // a: List(1, 2, 3, 4, 5, 6, 7, 8, 9)

// create a new list of all elements that are less than 5
val b = a.filter(_ < 5)            // b: List(1, 2, 3, 4)
val b = a.filter(e => e < 5)       // b: List(1, 2, 3, 4)

// create a list of all the even numbers in the list
val evens = x.filter(_ % 2 == 0)   // evens: List(2, 4, 6, 8)
```


## Use filterInPlace on mutable collections

When you have a mutable collection like `ArrayBuffer`, use `filterInPlace` rather than `filter`:

```scala
import scala.collection.mutable.ArrayBuffer
val a = ArrayBuffer.range(1,10)   // ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)

a.filterInPlace(_ < 5)   // a: ArrayBuffer(1, 2, 3, 4)
a.filterInPlace(_ > 2)   // a: ArrayBuffer(3, 4)
```


## Your predicate controls the filtering

How you filter the elements in your collection is entirely up to your algorithm:

```scala
val fruits = List("orange", "peach", "apple", "banana")

val x = fruits.filter(f => f.startsWith("a"))   // List(apple)
val x = fruits.filter(_.startsWith("a"))        // List(apple)
val x = fruits.filter(_.length > 5)             // List(orange, banana)
```


## Using the collect method to filter a collection

The `collect` method:

```scala
val x = List(0,1,2)
val x: List[Int] = List(0, 1, 2)

val y = x.collect{ case i: Int if i > 0 => i }
val y: List[Int] = List(1, 2)

val x = List(Some(1), None, Some(3))
val x: List[Option[Int]] = List(Some(1), None, Some(3))

val y = x.collect{ case Some(i) => i }
val y: List[Int] = List(1, 3)
```

The second example with the `List[Option]` values is more easily reduced with `flatten`:

```scala
x.flatten
val res0: List[Int] = List(1, 3)
```

There’s also a `collectFirst` method, which returns the first element it matches as an `Option`:

```scala
val firstTen = (1 to 10).toList
// result:
// val firstTen: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

firstTen.collectFirst{case x if x > 1 => x}
// result:
// val res0: Option[Int] = Some(2)

firstTen.collectFirst{case x if x > 99 => x}
// result:
// val res1: Option[Int] = None
```








