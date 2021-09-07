# Recipe 15.5, Storing Values in a Set in Sorted Order


Use:

- `SortedSet` (immutable or mutable)
- `LinkedHashSet`


## SortedSet

`SortedSet` returns elements in a sorted order. Immutable:

```scala
import scala.collection.immutable.SortedSet

val s = SortedSet(10, 4, 8, 2)          // s: TreeSet(2, 4, 8, 10)
val s = SortedSet('b', 'a', 'd', 'c')   // s: TreeSet(a, b, c, d)

// add and remove
val s1 = SortedSet(10)       // s1: TreeSet(10)
val s2 = s1 + 4              // s2: TreeSet(4, 10)
val s3 = s2 ++ List(8, 2)    // s3: TreeSet(2, 4, 8, 10)
val s4 = s3 - 8              // s4: TreeSet(2, 4, 10)
val s5 = s4 -- List(2, 10)   // s5: TreeSet(4)
```


## LinkedHashSet

`LinkedHashSet` is mutable, saves elements in insertion order:

```scala
import scala.collection.mutable.LinkedHashSet

val s = LinkedHashSet(10, 4, 8, 2)   // s: LinkedHashSet(10, 4, 8, 2)
```

Use methods like `+=` and `++=` to add elements, and `-=` and `--=` to remove elements:

```scala
val s = LinkedHashSet(10)   // s: LinkedHashSet(10)
s += 4                      // s: LinkedHashSet(10, 4)
s ++= List(8, 2)            // s: LinkedHashSet(10, 4, 8, 2)
s -= 4                      // s: LinkedHashSet(10, 8, 2)
s --= List(8, 10)           // s: LinkedHashSet(2)

// attempting to add an element that’s already in the set
// is quietly rejected
val s = LinkedHashSet(2)    // s: LinkedHashSet(2)
s += 2                      // s: LinkedHashSet(2)
s ++= List(2,2,2)           // s: LinkedHashSet(2)
```




