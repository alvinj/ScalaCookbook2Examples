# Recipe 13.2, Looping over a Collection with foreach

Given a `Vector[Int]`:

```scala
val nums = Vector(1, 2, 3)
```

you can write a function that takes an `Int` parameter and returns nothing:

```scala
def printAnInt(i: Int): Unit = println(i)
```

Because `printAnInt` matches the signature `foreach` requires, you can use it with `nums` and `foreach`:

```scala
nums.foreach(i => printAnInt(i))
```

You can also write that expression like this:

```scala
nums.foreach(printAnInt(_))
nums.foreach(printAnInt)     // most common
```

Can also solve this problem by writing an anonymous function that you pass into `foreach`:

```scala
nums.foreach(i => println(i))
nums.foreach(println(_))
nums.foreach(println)        // most common
```


## foreach on Maps

You can handle `Map.foreach` parameters as a tuple:

```scala
val m = Map("first_name" -> "Nick", "last_name" -> "Miller")

// Scala 2 tuple syntax
m.foreach(t => println(s"${t._1} -> ${t._2}"))

// Scala 3 tuple syntax
m.foreach(t => println(s"${t(0)} -> ${t(1)}"))
```

You can also use this approach:

```scala
m.foreach {
    (fname, lname) => println(s"$fname -> $lname")
}
```


## Discussion

To use `foreach` with a multiline function:

```scala
val longWords = StringBuilder()

"Hello world it’s Al".split(" ").foreach { e =>
    if e.length > 4 then longWords.append(s" $e")
    else println("Not added: " + e)
}
```

When that code is run in the REPL, it produces this output:

....
Not added: it’s
Not added: Al
val longWords: StringBuilder = Hello world
....



