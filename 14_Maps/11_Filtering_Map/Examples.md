# Recipe 14.11, Filtering a Map


## Mutable maps

Use `filterInPlace`:

```scala
val x = collection.mutable.Map(
    1 -> 100,
    2 -> 200,
    3 -> 300
)

x.filterInPlace((k,v) => k > 1)     // x: HashMap(2 -> b, 3 -> c)
x.filterInPlace((k,v) => v > 200)   // x: HashMap(3 -> 300)
```


## Mutable and immutable maps

Use a predicate with `filterKeys` (and a view):

```scala
val x = Map(
    1 -> "a", 
    2 -> "b", 
    3 -> "c"
)

val y = x.view.filterKeys(_ > 2).toMap   // y: Map(3 -> c)
```

If you don’t call `toMap` at the end, you’ll see this result:

```scala
val y = x.view.filterKeys(_ > 2)

// result:
// val y: scala.collection.MapView[Int, String] = MapView(<not computed>)
```

If your algorithm is longer, you can define a function (or method), and then pass it to `filterKeys`:

```scala
def only1(i: Int) = 
    if i == 1 then true else false
```

Pass the method to `filterKeys`:

```scala
val x = Map(1 -> "a", 2 -> "b", 3 -> "c")
val y = x.view.filterKeys(only1).toMap   // y: Map(1 -> a)
```

Can also use a `Set` with `filterKeys`:

```scala
val x = Map(1 -> "a", 2 -> "b", 3 -> "c")
val y = x.view.filterKeys(Set(2,3)).toMap
    // y: Map[Int, String] = Map(2 -> b, 3 -> c)
```



## Discussion

`filter` on a map:

```scala
// an immutable map
val a = Map(1 -> "a", 2 -> "b", 3 -> "c")

// filter by the key
val b = a.filter((k,v) => k > 1)       // b: Map(2 -> b, 3 -> c)

// filter by the value
val c = a.filter((k,v) => v != "b")    // c: Map(1 -> a, 3 -> c)
```

`filter` can also use a tuple:

```scala
// filter by the key (t._1)
val b = a.filter((t) => t._1 > 1)      // b: Map(2 -> b, 3 -> c)

// filter by the value (t._2)
val b = a.filter((t) => t._2 != "b")   // b: Map(1 -> a, 3 -> c)
```

`take` lets you keep the first N elements from the map:

```scala
val b = a.take(2)                      // b: Map(1 -> a, 2 -> b)
```




