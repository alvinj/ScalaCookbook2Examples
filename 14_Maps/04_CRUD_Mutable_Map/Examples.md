# Recipe 14.4, Adding, Updating, and Removing Elements in Mutable Maps


Given a mutable `Map`:

```scala
val m = scala.collection.mutable.Map[Int, String]()
```

Add an element:

```scala
m(1) = "a"        // m: HashMap(1 -> a)
```

Add elements with `+=`:

```scala
m += (2 -> "b")   // m: HashMap(1 -> a, 2 -> b)
```

Add multiple elements using `++=`:

```scala
m ++= Map(3 -> "c", 4 -> "d")
    // m: HashMap(1 -> a, 2 -> b, 3 -> c, 4 -> d)

m ++= List(5 -> "e", 6 -> "f")
    // m: HashMap(1 -> a, 2 -> b, 3 -> c, 4 -> d, 5 -> e, 6 -> f)
```

Remove a single element by specifying its key with the `-=` method:

```scala
m -= 1            // m: HashMap(2 -> b, 3 -> c, 4 -> d, 5 -> e, 6 -> f)
```

Remove multiple elements by key with `--=`:

```scala
m --= List(2,3)   // m: HashMap(4 -> d, 5 -> e, 6 -> f)
```

Update elements by reassigning their key to a new value:

```scala
m(4) = "DD"       // m: HashMap(4 -> DD, 5 -> e, 6 -> f)
```



## Discussion

Given this mutable `Map`:

```scala
val m = collection.mutable.Map(
    "AK" -> "Alaska",
    "IL" -> "Illinois",
    "KY" -> "Kentucky"
)
```

Examples:

```scala
// returns None if the key WAS NOT in the map
val x = m.put("CO", "Colorado")
    // x: Option[String] = None
    // m: HashMap(AK -> Alaska, IL -> Illinois, CO -> Colorado, KY -> Kentucky)

// returns Some if the key WAS in the map
val x = m.put("CO", "Colorado")
    // x: Option[String] = Some(Colorado)
    // m: HashMap(AK -> Alaska, IL -> Illinois, CO -> Colorado, KY -> Kentucky)

m.filterInPlace((k,v) => k == "AK")
    // m: HashMap(AK -> Alaska)

// `remove` returns a Some if the key WAS in the map
val x = m.remove("AK")
    // x: Option[String] = Some(Alaska)
    // m: collection.mutable.Map[String, String] = HashMap()

// `remove` returns a None if the key WAS NOT in the map
val x = m.remove("FOO")
    // x: Option[String] = None
    // m: collection.mutable.Map[String, String] = HashMap()

m.clear   // m: HashMap()
```

The comments in the examples explain when methods like `put` and `remove` return `Some` and `None` values.







