# Recipe 13.15, Converting a Collection to a String with mkString and addString


## Solution

Use the `mkString` or `addString` methods to print a collection as a `String`. 


### mkString

Given a simple collection:

```scala
val x = Vector("apple", "banana", "cherry")
```

convert the elements to a `String` using `mkString`:

```scala
x.mkString   // "applebananacherry"
```

Add a separator:

```scala
x.mkString(" ")    // "apple banana cherry"
x.mkString("|")    // "apple|banana|cherry"
x.mkString(", ")   // "apple, banana, cherry"
```

add a prefix and suffix:

```scala
x.mkString("[", ", ", "]")   // "[apple, banana, cherry]"
```

There’s also a `mkString` method on `Map` classes:

```scala
val a = Map(1 -> "one", 2 -> "two")

a.mkString                      // "1 -> one2 -> two"
a.mkString("|")                 // "1 -> one|2 -> two"
a.mkString("| ", " | ", " |")   // "| 1 -> one | 2 -> two |"
```


### addString

Beginning with Scala 2.13, a new `addString` method is similar to `mkString`, but lets you fill a mutable `StringBuilder` with the contents of the sequence:

```scala
val x = Vector("a", "b", "c")

val sb = StringBuilder()
val y = x.addString(sb)          // y: StringBuilder = abc

val sb = StringBuilder()
val y = x.addString(sb , ", ")   // y: StringBuilder = "a, b, c"

val sb = StringBuilder()
val y = x.addString(
    sb,     // StringBuilder
    "[",    // start
    ", ",   // separator
    "]"     // end
)

// result of the last expression:
y: StringBuilder = [a, b, c]
y(0)   // Char = '['
y(1)   // Char = 'a'
```

Because this technique uses a `StringBuilder` instead of a `String`, it should be faster with large data sets. (As usual, always test any performance-related concern.)



## Discussion

The technique works well for types like strings and integers, but if you have a simple class like this `Person` class that doesn’t implement a `toString` method, and then put a `Person` in a `List`, the resulting string won’t be very useful:

```scala
class Person(val name: String)
val xs = List(Person("Schmidt"))
xs.mkString   // Person@1b17b5cb (not a useful result)
```

To solve that problem, properly implement the `toString` method in your class:

```scala
class Person(val name: String):
    override def toString = name

List(Person("Schmidt")).mkString   // "Schmidt"
```


### Creating a string from a repeated character

You can fill a sequence with a `Char` or `String` using this technique:

```scala
val list = List.fill(5)('-')            // List(-, -, -, -, -)
```

Then convert that list to a `String` 

```scala
val list = List.fill(5)('-').mkString   // "```-"
```

A simpler technique is to multiply a desired string to create a resulting string, like this:

```scala
"\u2500" * 10   // String = ──────────
```

I write more about these techniques in my blog post, [Scala functions to repeat a character n times](https://alvinalexander.com/scala/scala-functions-repeat-character-n-times-padding-blanks).




