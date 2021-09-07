# Recipe 14.9, Traversing a Map


A sample map:

```scala
val ratings = Map(
    "Lady in the Water"-> 3.0,
    "Snakes on a Plane"-> 4.0,
    "You, Me and Dupree"-> 3.5
)
```

`for` loop:

```scala
for (k,v) <- ratings do println(s"key: $k, value: $v")
```

`foreach`:

```scala
ratings.foreach {
    case(movie, rating) => println(s"key: $movie, value: $rating")
}
```

How to use the tuple syntax to access the key and value fields:

```scala
ratings.foreach(x => println(s"key: ${x._1}, value: ${x._2}"))
```



## Discussion

The `foreach` method with an anonymous function can be written three different ways with Scala 3:

```scala
ratings.foreach {
    (movie, rating) => println(s"key: $movie, value: $rating")
}

ratings.foreach {
    case movie -> rating => println(s"key: $movie, value: $rating")
}

// works with Scala 2
ratings.foreach {
    case(movie, rating) => println(s"key: $movie, value: $rating")
}
```


## Keys

To access the keys, use `keysIterator`:

```scala
val i = ratings.keysIterator

// the iterator provides access to the map’s keys
i.toList   // List(Lady in the Water, Snakes on a Plane, You, Me and Dupree)

ratings.keys.foreach((m) => println(s"$m rating is ${ratings(m)}"))

// results:
Lady in the Water rating is 3.0
Snakes on a Plane rating is 4.0
You, Me and Dupree rating is 3.5
```


## Values

To traverse the map to perform an operation on its values, `mapValues` ... first call `view`:

```scala
val a = Map(1 -> "ay", 2 -> "bee")
    // a: Map[Int, String] = Map(1 -> ay, 2 -> bee)

val b = a.view.mapValues(_.toUpperCase).toMap   // Map(1 -> AY, 2 -> BEE)
```

Calling `mapValues` creates an iterator:

```scala
// `view` uses an iterator
a.view                        // MapView(<not computed>)
```

Conversely, you can use the `values` method and `map`:

```scala
a.values.map(_.toUpperCase)   // List(AY, BEE)
```

But be aware that the first step in this process creates an intermediate `Iterable`:

// verified with dotr
```scala
a.values                      // Iterable(ay, bee)
```

For a large map this approach can create a performance or memory problem because of that additional, intermediate collection.


## If you need to transform the values

Traverse a map to transform the map values:

```scala
val map1 = Map(1 -> 10, 2 -> 20, 3 -> 30)

// use the map keys and values to create new values
val map2 = map1.transform((k,v) => k + v)
    // map2: Map(1 -> 11, 2 -> 22, 3 -> 33)
```

For more complicated situations you can also create a view and then call the `map` method on that `MapView`:

```scala
val map3 = map1.view.map((k,v) => (k, k + v)).toMap
```


