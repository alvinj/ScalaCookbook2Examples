# Recipe 14.10, Sorting an Existing Map by Key or Value


A basic, immutable `Map`:

```scala
val grades = Map(
    "Kim" -> 90,
    "Al" -> 85,
    "Melissa" -> 95,
    "Emily" -> 91,
    "Hannah" -> 92
)
```

Sort the map by _key_, from low to high, using `sortBy`, and then store the result in a mutable `LinkedHashMap` or immutable `VectorMap`:

```scala
import scala.collection.mutable.LinkedHashMap

// Version 1: sorts by key by accessing each tuple as '(k,v)'
val x = LinkedHashMap(grades.toSeq.sortBy((k,v) => k):_*)
    // x: LinkedHashMap(Al -> 85, Emily -> 91, Hannah -> 92, Kim -> 90, 
    //                  Melissa -> 95)

// Version 2: sorts by key using the tuple '._1' syntax
val x = LinkedHashMap(grades.toSeq.sortBy(_._1):_*)
    // x: LinkedHashMap(Al -> 85, Emily -> 91, Hannah -> 92, Kim -> 90, 
    //                  Melissa -> 95)
```

Sort the keys in ascending or descending order using `sortWith` and a custom algorithm:

```scala
// sort by key, low to high
val x = LinkedHashMap(grades.toSeq.sortWith(_._1 < _._1):_*)
    // x: LinkedHashMap(Al -> 85, Emily -> 91, Hannah -> 92, Kim -> 90, 
    //                  Melissa -> 95)

// sort by key, high to low
val x = LinkedHashMap(grades.toSeq.sortWith(_._1 > _._1):_*)
    // x: LinkedHashMap(Melissa -> 95, Kim -> 90, Hannah -> 92, Emily -> 91,
    //                  Al -> 85)
```

You can sort the map by _value_ using `sortBy`:

```scala
// value, low to high, accessing elements as `(k,v)`
val x = LinkedHashMap(grades.toSeq.sortBy((k,v) => v):_*)
    // x: LinkedHashMap(Al -> 85, Kim -> 90, Emily -> 91, Hannah -> 92, 
    //                  Melissa -> 95)

// value, low to high, using the tuple `_` syntax
val x = LinkedHashMap(grades.toSeq.sortBy(_._2):_*)
    // x: LinkedHashMap(Al -> 85, Kim -> 90, Emily -> 91, Hannah -> 92, 
    //                  Melissa -> 95)
```


Sort by value in ascending or descending order using `sortWith`:

```scala
// sort by value, low to high
val x = LinkedHashMap(grades.toSeq.sortWith(_._2 < _._2):_*)
    // x: LinkedHashMap(Al -> 85, Kim -> 90, Emily -> 91, Hannah -> 92, 
    //                  Melissa -> 95)

// sort by value, high to low
val x = LinkedHashMap(grades.toSeq.sortWith(_._2 > _._2):_*)
    // x: LinkedHashMap(Melissa -> 95, Hannah -> 92, Emily -> 91, Kim -> 90, 
    //                  Al -> 85)
```

You can also store the results in an immutable `VectorMap`.


## Discussion

Same example with smaller pieces ... start with the basic immutable `Map`:

```scala
val grades = Map(
    "Kim" -> 90,
    "Al" -> 85,
    "Melissa" -> 95,
    "Emily" -> 91,
    "Hannah" -> 92
)
```

`grades.toSeq` creates a sequence of two-element tuple values:

```scala
val x = grades.toSeq
    // x: ArrayBuffer((Hannah,92), (Melissa,95), (Kim,90), (Emily,91), (Al,85))
```

Make the conversion to a `Seq` for its sorting methods:

```scala
// sort by key
val x = grades.toSeq.sortBy(_._1)
    // x: Seq[(String, Int)] = 
    // ArrayBuffer((Al,85), (Emily,91), (Hannah,92), (Kim,90), (Melissa,95))

// sort by key
val x = grades.toSeq.sortWith(_._1 < _._1)
    // x: Seq[(String, Int)] =
    // ArrayBuffer((Al,85), (Emily,91), (Hannah,92), (Kim,90), (Melissa,95))
```

Store the results in a `LinkedHashMap`, `VectorMap`, or `ListMap` to retain the sorted order:

```scala
val x = LinkedHashMap(grades.toSeq.sortBy(_._1):_*)
    // x: scala.collection.mutable.LinkedHashMap[String,Int] =
    // Map(Al -> 85, Emily -> 91, Hannah -> 92, Kim -> 90, Melissa -> 95)
```


===== About that _*


```scala
val seqOfTuples = grades.toSeq.sortBy(_._1)
    // seqOfTuples: Seq[(String, Int)] =
    // List((Al,85), (Emily,91), (Hannah,92), (Kim,90), (Melissa,95))
```

Give the `VectorMap`’s `apply` method what it wants:

```scala
val x = VectorMap(seqOfTuples: _*)
    // x: scala.collection.immutable.VectorMap[String, Int] =
    // VectorMap(Al -> 85, Emily -> 91, Hannah -> 92, Kim -> 90, Melissa -> 95)
```

Another way to see how `_*` works is to define your own method that takes a varargs parameter:

```scala
def printAll(strings: String*): Unit = strings.foreach(println)
```

Then create a `List`:

```scala
// a sequence of strings
val fruits = List("apple", "banana", "cherry")
```

see that you can’t pass that `List` into `printAll`; it fails like the previous example:

```scala
printAll(fruits)

// result:
1 |printAll(fruits)
  |         ^^^^^^
  |         Found:    (fruits : List[String])
  |         Required: String
```

But you can use `_*` to adapt the `List` to work with `printAll`:

....
// this works
printAll(fruits: _*)                                                                              
// result:                             
apple
banana
cherry
....








