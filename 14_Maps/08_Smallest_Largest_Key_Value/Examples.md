# Recipe 14.8, Finding the Largest (or Smallest) Key or Value in a Map

Create a sample `Map`:

```scala
val grades = Map(
    "Al" -> 80,
    "Kim" -> 95, 
    "Teri" -> 85, 
    "Julia" -> 90
)
```

The “largest” key using the natural `String` sort order:

```scala
grades.max   // (Teri,85)
grades.min   // (Al,80)
```

Can also call `keysIterator` to get an iterator over the map keys, and call its `max` and `min` methods:

```scala
grades.keysIterator.max   // Teri
grades.keysIterator.min   // Al
```

You can also find the same max and min values by getting the `keysIterator` and using `reduceLeft`:

```scala
grades.keysIterator.reduceLeft((x,y) => if x > y then x else y)
// result:
// val res2: String = Teri

grades.keysIterator.reduceLeft((x,y) => if x < y then x else y)
// result:
// val res3: String = Al
```

This approach is flexible, because if your definition of “largest” is the longest string, you can compare string lengths instead:

```scala
grades.keysIterator.reduceLeft((x,y) => if x.length > y.length then x else y)
// result:
// res4: String = Julia
```


## Discussion

When you need to find the largest and smallest _values_ in a `Map`, use the `valuesIterator` method to iterate through the values, while calling the `max` or `min` method on the iterator:

```scala
grades.valuesIterator.max   // 95
grades.valuesIterator.min   // 80
```

You can also use `max` and `min` with `reduceLeft`:

```scala
grades.valuesIterator.reduceLeft(_ max _)   // 95
grades.valuesIterator.reduceLeft(_ min _)   // 80
```

The benefit of using `reduceLeft` is that you can compare _any_ type of value with your own custom algorithm, which is representative of what you may need to do with more complex data types. These examples demonstrate how to use `reduceLeft` with a slightly more complicated algorithm:

```scala
// max
grades.valuesIterator.reduceLeft((x,y) => if x > y then x else y)
// result:
// val res5: Int = 95

// min
grades.valuesIterator.reduceLeft((x,y) => if x < y then x else y)
// result:
// val res6: Int = 80
```




