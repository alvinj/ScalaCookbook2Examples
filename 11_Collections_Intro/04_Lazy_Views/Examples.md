# Recipe 11.4, Creating a Lazy View on a Collection


For example, given a large list:

```scala
val xs = List.range(0, 3_000_000)   // a list from 0 to 2,999,999
```

Imagine that you want to call several transformation methods on it, such as `map` and `filter`. This is a contrived example, but it demonstrates a problem:

```scala
val ys = xs.map(_ + 1)
           .map(_ * 10)
           .filter(_ > 1_000)
           .filter(_ < 10_000)
```

If you attempt to run that example in the REPL, you’ll probably see this fatal “out of memory” error:

....
scala> val ys = xs.map(_ + 1)
java.lang.OutOfMemoryError: GC overhead limit exceeded
....

Conversely, this example returns almost immediately and doesn’t throw an error because all it does is create a view and then four lazy transformer methods:

```scala
val ys = xs.view
           .map(_ + 1)
           .map(_ * 10)
           .filter(_ > 1_000)
           .filter(_ < 10_000)

// result: ys: scala.collection.View[Int] = View(<not computed>)
```

Now you can work with `ys` without running out of memory:

[subs=+quotes]
....
scala> ys.take(3).foreach(println)
1010
1020
1030
....

Calling `view` on a collection makes the resulting collection lazy. 

Other methods like `foreach` that don’t transform a collection are evaluated eagerly. This explains why transformer methods like these return a view:

```scala
val a = List.range(0, 1_000_000)
val b = a.view.map(_ + 1)   // SeqView[Int] = SeqView(<not computed>)
val c = b.take(3)           // SeqView[Int] = SeqView(<not computed>)
```

and why `foreach` causes action to happen:

....
scala> c.foreach(println)
1
2
3
....



### The use case for views

```scala
val b = a.map(_ + 1)           // 1st copy of the data
         .map(_ * 10)          // 2nd copy of the data
         .filter(_ > 1_000)    // 3rd copy of the data
         .filter(_ < 10_000)   // 4th copy of the data
```

To drive that point home, that approach is the same as if you had written this:

```scala
val a = List.range(0, 1_000_000_000)   // 1B elements in RAM
val b = a.map(_ + 1)           // 1st copy of the data (2B elements in RAM)
val c = b.map(_ * 10)          // 2nd copy of the data (3B elements in RAM)
val d = c.filter(_ > 1_000)    // 3rd copy of the data (~4B total)
val e = d.filter(_ < 10_000)   // 4th copy of the data (~4B total)
```





