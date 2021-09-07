# Recipe 15.3, Creating a Set and Adding Elements to It


## Immutable Set

Create a new immutable set and add elements to it:

```scala
val s1 = Set(1, 2)          // s1: Set[Int] = Set(1, 2)
```

Use `+` and `++` to add new elements to an immutable `Set`:

```scala
// add one element
val s2 = s1 + 3             // s2: Set(1, 2, 3)

// add multiple elements from another sequence
val s3 = s2 ++ List(4, 5)   // s3: Set(5, 1, 2, 3, 4)
```

Same thing with a `var` field:

```scala
var s = Set(1, 2)     // s: Set[Int] = Set(1, 2)
s = s + 3             // s: Set(1, 2, 3)
s += 4                // s: Set(1, 2, 3, 4)
s = s ++ List(5, 6)   // s: HashSet(5, 1, 6, 2, 3, 4)
```


## Mutable Set

Add elements to a _mutable_ `Set` with the `+=`, `++=`, and “add” methods:

```scala
// declare that you want a set of Ints
val s = scala.collection.mutable.Set[Int]()
    // s: Set[Int] = HashSet()

// add one element; += is an alias for addOne
s += 1                // s: HashSet(1)
s.addOne(2)           // s: HashSet(1, 2)

// add multiple elements; ++= is an alias for addAll
s ++= List(3, 4)      // s: HashSet(1, 2, 3, 4)
s.addAll(List(5, 6))  // s: HashSet(1, 2, 3, 4, 5, 6)

// note that there is no error when you attempt to add a duplicate element
s += 2                // s: HashSet(1, 2, 3, 4, 5, 6)

// add elements from any sequence (any IterableOnce)
s ++= Vector(7, 8)    // s: HashSet(1, 2, 3, 4, 5, 6, 7, 8)

// the `add` method returns true if the element is added to the set,
// false otherwise
val res = s.add(99)   // res=true,  s=HashSet(1, 2, 3, 99, 4, 5, 6, 7, 8)
val res = s.add(1)    // res=false, s=HashSet(1, 2, 3, 99, 4, 5, 6, 7, 8)
```

Test to see whether a set contains an element before adding it:

```scala
s.contains(5)         // true
```

Add elements to a mutable set when you declare it:

```scala
import scala.collection.mutable.Set
val s = Set(1, 2, 3)
    // s: scala.collection.mutable.Set[Int] = HashSet(1, 2, 3)
```






