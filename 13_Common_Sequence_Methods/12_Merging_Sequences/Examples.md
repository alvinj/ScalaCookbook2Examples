# Recipe 13.12, Merging Sequential Collections


## The ++ or concat methods

The `++` method is an alias for the `concat` method, so use either one:

```scala
val a = List(1,2,3)
val b = Vector(4,5,6)

val c = a ++ b        // c: List[Int] = List(1, 2, 3, 4, 5, 6)
val c = a.concat(b)   // c: List[Int] = List(1, 2, 3, 4, 5, 6)

val d = b ++ a        // d: Vector[Int] = Vector(4, 5, 6, 1, 2, 3)
val d = b.concat(a)   // d: Vector[Int] = Vector(4, 5, 6, 1, 2, 3)
```


## The ++= method

Use the `++=` method to merge a sequence into an existing mutable sequence like an `ArrayBuffer`:

```scala
import collection.mutable.ArrayBuffer

// merge sequences into an ArrayBuffer
val a = ArrayBuffer(1,2,3)
a ++= Seq(4,5,6)   // a: ArrayBuffer(1, 2, 3, 4, 5, 6)
a ++= List(7,8)    // a: ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8)
```


## Use ::: to merge two Lists

If you’re working with a `List`, use `:::` to prepend the elements of one list to another list:

```scala
val a = List(1,2,3,4)
val b = List(4,5,6,7)

val c = a ::: b   // c: List(1, 2, 3, 4, 4, 5, 6, 7)
```


## intersect and diff

The `intersect` method finds the intersection of two sequences — the elements that are common to both sequences:

```scala
val a = Vector(1,2,3,4,5)
val b = Vector(4,5,6,7,8)

val c = a.intersect(b)   // c: Vector(4, 5)
val c = b.intersect(a)   // c: Vector(4, 5)
```

The `diff` method provides the “difference” between two sequences:

```scala
val a = List(1,2,3,4)
val b = List(3,4,5,6)
val c = a.diff(b)   // c: List(1, 2)
val c = b.diff(a)   // c: List(5, 6)

val a = List(1,2,3,4,1,2,3,4)
val b = List(3,4,5,6,3,4,5,6)
val c = a.diff(b)   // c: List(1, 2, 1, 2)
val c = b.diff(a)   // c: List(5, 6, 5, 6)
```

You may also need to use the `distinct` method to create lists of distinct elements:

```scala
val a = List(1,2,3,4,1,2,3,4)
val b = List(3,4,5,6,3,4,5,6)

val c = a.diff(b)            // c: List(1, 2, 1, 2)
val c = b.diff(a)            // c: List(5, 6, 5, 6)

val c = a.diff(b).distinct   // c: List(1, 2)
val c = b.diff(a).distinct   // c: List(5, 6)
```


## Discussion

You can use `diff` to get the _relative complement_ of two sets. On a recent project, I needed to find a list of unique elements in one sequence that _were not_ in another sequence. I did this by first calling `distinct` on the two sequences, and then using `diff` to compare them. For instance, given these two vectors:

```scala
val a = Vector(1,2,3,11,4,12,4,4,5)
val b = Vector(6,7,4,4,5)
```

one way to find the relative complement of each vector is to first call `distinct` on that vector, and then compare it to the other with `diff`:

```scala
// the elements in a that are not in b
val uniqToA = a.distinct.diff(b)   // Vector(1, 2, 3, 11, 12)

// the elements in b that are not in a
val uniqToB = b.distinct.diff(a)   // Vector(6, 7)
```

You can sum those results to get the list of elements that are either in the first set or the second set, but not both sets:

```scala
val uniqs = uniqToA ++ uniqToB     // Vector(1, 2, 3, 11, 12, 6, 7)
```

Here’s another way to get that same result:

```scala
// create a list of unique elements that are common to both lists
val i = a.intersect(b).toSet       // Set(4, 5)

// subtract those elements from the original lists
val uniqToA = a.toSet -- i         // HashSet(1, 2, 12, 3, 11)
val uniqToB = b.toSet -- i         // Set(6, 7)

val uniqs = uniqToA ++ uniqToB     // HashSet(1, 6, 2, 12, 7, 3, 11)
```

Note that I use `toSet` in this solution because it’s another way to create a list of unique elements in a sequence.



