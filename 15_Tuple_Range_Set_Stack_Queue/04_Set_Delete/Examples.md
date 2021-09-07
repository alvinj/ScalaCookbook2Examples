# Recipe 15.4, Deleting Elements from Sets


## Immutable Set

Use the `-` and `--` methods to remove elements:

```scala
// create an immutable set
val s1 = Set(1, 2, 3, 4, 5, 6)   // s1: Set[Int] = HashSet(5, 1, 6, 2, 3, 4)

// remove one element
val s2 = s1 - 1                  // s2 == HashSet(5, 6, 2, 3, 4)

// remove multiple elements defined in another sequence
val s3 = s2 -- Seq(4, 5)         // s3 == HashSet(6, 2, 3)
```

Can also use filtering methods:

```scala
val s1 = Set(1, 2, 3, 4, 5, 6)   // s1: Set[Int] = HashSet(5, 1, 6, 2, 3, 4)
val s2 = s1.filter(_ > 3)        // s2: HashSet(5, 6, 4)
val s3 = s1.take(2)              // s3: HashSet(5, 1)
val s4 = s1.drop(2)              // s4: HashSet(6, 2, 3, 4)
```

Methods like `take` and `drop` are rarely used:

```scala
val set = List.range(0, 1_000_000).toSet
set.take(3)   // HashSet(769962, 348877, 864012)
```


## Mutable Set

Remove elements from a _mutable_ `Set` using `-=` and `--=`:

```scala
val s = scala.collection.mutable.Set(1, 1, 1, 2, 3, 4, 5, 6, 7, 8)
// s: scala.collection.mutable.Set[Int] = HashSet(1, 2, 3, 4, 5, 6, 7, 8)
```

Remove one element using `-=` method or `subtractOne`:

```scala
// '-=' is an alias for 'subtractOne'
s -= 1                     // s: HashSet(2, 3, 4, 5, 6, 7, 8)
s.subtractOne(2)           // s: HashSet(3, 4, 5, 6, 7, 8)
```

Remove multiple elements using `--=` or `subtractAll`:

```scala
// '--=' is an alias for 'subtractAll'
s --= List(3,4,5)          // s: HashSet(6, 7, 8)
s.subtractAll(List(6,7))   // s: HashSet(8)
```

Notice that attempting to remove elements that don’t exist doesn’t throw an exception, or report an error:

```scala
s -= 99                    // s: HashSet(8)
```

Use other methods like `filterInPlace`, `clear`, and `remove`:

```scala
val s = scala.collection.mutable.Set(1, 2, 3, 4, 5)
s.filterInPlace(_ > 2)     // s: HashSet(3, 4, 5)
s.clear                    // s: HashSet()
```

`remove` returns `true` if an element is removed, and `false` otherwise:

```scala
val s = scala.collection.mutable.Set(1, 2, 3, 4, 5)
val res = s.remove(2)      // res=true,  s=HashSet(1,3,4,5)
val res = s.remove(99)     // res=false, s=HashSet(1,3,4,5)
```




