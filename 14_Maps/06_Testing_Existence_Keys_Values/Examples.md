# Recipe 14.6, Testing for the Existence of a Key or Value in a Map


## Testing for keys

Use `contains`:

```scala
val states = Map(
    "AK" -> "Alaska",
    "IL" -> "Illinois",
    "KY" -> "Kentucky"
)

states.contains("FOO")   // false
states.contains("AK")    // true
```

Use `get`:

```scala
states.get("FOO")        // None
states.get("AK")         // Some(Alaska)
```

Use `get` in a `match` expression:

```scala
states.get("AK") match
    case Some(state) => println(s"state = $state")
    case None => println("state not found")
```

As shown in the previous recipe, note that attempting to use a key that isn’t in the map will throw an exception:

```scala
states("AL")             // java.util.NoSuchElementException: key not found: AL
```



## Testing for values

To test whether a _value_ exists in a map, use the `valuesIterator` method to search for the value using `contains`:

```scala
states.valuesIterator.contains("Alaska")     // true
states.valuesIterator.contains("Kentucky")   // true
states.valuesIterator.contains("ucky")       // false
```

This works because (a) the `valuesIterator` method returns an `Iterator`:

```scala
states.valuesIterator   // Iterator[String] = <iterator>
```

and (b) `contains` returns `true` if the element you supply is a value in the map.

Another way to search map values:

```scala
states.valuesIterator.exists(_.contains("ucky"))   // true
states.valuesIterator.exists(_.matches("Ala.*"))   // true
```



