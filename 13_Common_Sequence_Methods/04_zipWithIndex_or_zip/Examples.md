# Recipe 13.4, Using zipWithIndex or zip to Create Loop Counters

Assuming you have a list of characters:

```scala
val chars = List('a', 'b', 'c')
```

Here’s `zipWithIndex`, `foreach`, and `case`:

```scala
chars.zipWithIndex.foreach {
    case (c, i) => println(s"character '$c' has index $i")
}

// output:
character 'a' has index 0
character 'b' has index 1
character 'c' has index 2
```

`zipWithIndex` returns a series of two-element tuples (“tuple-2”) in a sequence, like this:

....
List( (a,0), (b,1), ...
....

`foreach` passes a tuple-2 to your algorithm, so you can also write this:

```scala
// Scala 2 tuple syntax
chars.zipWithIndex.foreach { t =>
    println(s"character '${t._1}' has index ${t._2}")
}

// Scala 3 tuple syntax
chars.zipWithIndex.foreach { t =>
    println(s"character '${t(0)}' has index ${t(1)}")
}
```

You can also use a `for` loop:

```scala
for
    (c, i) <- chars.zipWithIndex
do
    println(s"character '$c' has index $i")
```



## Control the starting value with zip

When you use `zipWithIndex` the counter always starts at `0`. To control the starting value, use `zip` instead:

```scala
for ((c,i) <- chars.zip(LazyList from 1)) {
    println(s"${c} is #${i}")
}

// output
a is #1
b is #2
c is #3
```



## Discussion

When called on a sequence, `zipWithIndex` returns a sequence of tuple-2 elements:

```scala
val chars = List(\'a', \'b', \'c')
val chars: List[Char] = List(a, b, c)

val zwi = chars.zipWithIndex   // zwi: List[(Char, Int)] = List((a,0), (b,1), (c,2))
```


### Using a case statement in curly braces

You can use a `case` statement with `foreach`:

```scala
chars.zipWithIndex.foreach {
    case (c, i) => println(s"character '$c' has index $i")
}
```

With Scala 2.13 and newer that can be written in any of these ways:

```scala
case(c, i) => println(s"character '$c' has index $i")     // shown previously
case(c -> i) => println(s"character '$c' has index $i")   // alternate
(c, i) => println(s"character '$c' has index $i")         // without the 'case'
```


### Using a lazy view

You may want to call `view` before invoking `zipWithIndex`:

....
val zwi2 = chars.view.zipWithIndex
zwi2: scala.collection.View[(Char, Int)] = View(<not computed>)
....




