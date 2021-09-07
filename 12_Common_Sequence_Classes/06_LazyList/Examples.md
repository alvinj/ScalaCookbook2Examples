# Recipe 12.6, Using LazyList, a Lazy Version of a List

Just like a `List` can be constructed with `::`, a `LazyList` can be constructed with the `#::` method, using `LazyList.empty` at the end of the expression instead of `Nil`:

```scala
val xs = 1 #:: 2 #:: 3 #:: LazyList.empty
// val xs: LazyList[Int] = LazyList(<not computed>)
```

As another example, create a `LazyList` with a range:

```scala
val xs = (1 to 100_000_000).to(LazyList)
// val xs: LazyList[Int] = LazyList(<not computed>)
```

The head is returned immediately:

```scala
xs.head
// res0: Int = 1
```

but the tail isn’t evaluated yet:

```scala
xs.tail
// val res1: LazyList[Int] = LazyList(<not computed>)
```

When transformers are called, you see the “<not computed>” output in the REPL:

```scala
xs.take(3)
// val res2: LazyList[Int] = LazyList(<not computed>)

xs.filter(_ < 200)
// val res3: LazyList[Int] = LazyList(<not computed>)

xs.filter(_ > 200)
// val res4: LazyList[Int] = LazyList(<not computed>)

xs.map { _ * 2 }
// val res5: LazyList[Int] = LazyList(<not computed>)
```

A `LazyList` gives you a chance to specify a huge list:

```scala
val xs = (1 to 100_000_000).to(LazyList)
xs(0)   // returns 1
xs(1)   // returns 2
```




