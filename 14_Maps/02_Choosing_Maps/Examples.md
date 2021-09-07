# Recipe 14.2, Choosing a Map Implementation


## SortedMap

A `Map` that returns its elements in sorted order by keys:

```scala
import scala.collection.SortedMap

val x = SortedMap(
    2 -> "b",
    4 -> "d",
    3 -> "c",
    1 -> "a"
)

// result:
val x: scala.collection.SortedMap[Int, String]
    = TreeMap(1 -> a, 2 -> b, 3 -> c, 4 -> d)
```


## Remember the insertion order with LinkedHashMap, VectorMap, or ListMap

`LinkedHashMap` only comes in a mutable form:

```scala
import collection.mutable.LinkedHashMap

val x = LinkedHashMap(   // x: LinkedHashMap(1 -> a, 2 -> b)
    1 -> "a",
    2 -> "b"
)

x += (3 -> "c")          // x: LinkedHashMap(1 -> a, 2 -> b, 3 -> c)
x += (4 -> "d")          // x: LinkedHashMap(1 -> a, 2 -> b, 3 -> c, 4 -> d)
```

`VectorMap`:

```scala
import collection.immutable.VectorMap

val a = VectorMap(           // a: VectorMap(10 -> a)
    10 -> "a"
)
val b = a ++ Map(7 -> "b")   // b: VectorMap(10 -> a, 7 -> b)
val c = b ++ Map(3 -> "c")   // c: VectorMap(10 -> a, 7 -> b, 3 -> c)
```


