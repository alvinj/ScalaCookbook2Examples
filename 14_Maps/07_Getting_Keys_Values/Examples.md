# Recipe 14.7, Getting the Keys or Values from a Map


## Keys (keySet, keys, keysIterator)

These methods are shown in the following examples:

```scala
val states = Map("AK" -> "Alaska", "AL" -> "Alabama", "AR" -> "Arkansas")

states.keySet          // Set[String] = Set(AK, AL, AR)
states.keys            // Iterable[String] = Set(AK, AL, AR)
states.keysIterator    // Iterator[String] = <iterator>
```


## Values (values, valuesIterator)

Examples:

```scala
states.values          // Iterable[String] = Iterable(Alaska, Alabama, Arkansas)
states.valuesIterator  // Iterator[String] = <iterator>
```




