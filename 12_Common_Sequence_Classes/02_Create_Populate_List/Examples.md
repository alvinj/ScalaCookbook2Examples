# Recipe 12.2, Creating and Populating a List


There are many ways to create and initially populate a `List`:

```scala
// (1) basic, general use cases
val xs = List(1, 2, 3)        // List(1, 2, 3)
val xs = 1 :: 2 :: 3 :: Nil   // List(1, 2, 3)
val xs = 1 :: List(2, 3)

// (2) both of these create an empty list
val xs: List[String] = List()
val xs: List[String] = Nil
```

These examples demonstrate how to let the compiler implicitly set the `List` type, and then how to explicitly control the type:

```scala
// (3a) implicit and explicit types, with mixed values
val xs = List(1, 2.0, 33D, 4_000L)   // implicit type (List[AnyVal])
val xs: List[Double] = List(1, 2.0, 33D, 4_000L)    // explicit type

// (3b) another example of explicitly setting the list type,
// where the second example declares the type to be List[Long]
val xs = List(1, 2, 3)               // List[Int] = List(1, 2, 3)
val xs: List[Long] = List(1, 2, 3)   // List[Long] = List(1, 2, 3)
```

These examples demonstrate a number of ways to create lists from ranges, including the `to` and `by` methods that are available on the `Int` and `Char` types:

```scala
// (4) using ranges
val xs = List.range(1, 10)      // List(1, 2, 3, 4, 5, 6, 7, 8, 9)
val xs = List.range(0, 10, 2)   // List(0, 2, 4, 6, 8)

(1 to 5).toList                 // List(1, 2, 3, 4, 5)
(1 until 5).toList              // List(1, 2, 3, 4)
(1 to 10 by 2).toList           // List(1, 3, 5, 7, 9)
(1 to 10 by 3).toList           // List(1, 4, 7, 10)

('a' to 'e').toList             // List(a, b, c, d, e)
('a' to 'e' by 2).toList        // List(a, c, e)
```

These examples demonstrate a variety of ways to to fill and populate lists:

```scala
// (5) different ways to fill lists
val xs = List.fill(3)("foo")            // xs: List(foo, foo, foo)
val xs = List.tabulate(5)(n => n * n)   // xs: List(0, 1, 4, 9, 16)
val xs = "hello".toList                 // xs: List[Char] = List(h,e,l,l,o)

// create a list of alphanumeric characters
val alphaNum = (('a' to 'z') ++ ('A' to 'Z') ++ ('0' to '9')).toList
    // result contains 52 letters and 10 numbers

// create a list of 10 printable characters
val r = scala.util.Random
val printableChars = (for i <- 0 to 10 yield r.nextPrintableChar).toList
    // result is like: List(=, *, W, ?, W, 1, L, <, F, d, O)
```

Finally, if you want to use a `List`, but the data is frequently changing, use a `ListBuffer` while the data is changing, and then convert it to a `List` when the data changes stop:

```scala
// (6) use a ListBuffer while data is frequently changing
import collection.mutable.ListBuffer
val a = ListBuffer(1)           // a: ListBuffer(1)
a += 2                          // a: ListBuffer(1, 2)
a += 3                          // a: ListBuffer(1, 2, 3)

// convert it to a List when the changes stop
val b = a.toList                // b: List(1, 2, 3)
```

A `ListBuffer` is a `Buffer` that’s backed by a linked list. It offers constant time prepend and append operations, and most other operations are linear.



## Discussion

A `List` in Scala is simply a collection of elements that ends with a `Nil` element:

```scala
// empty list
val xs: List[String] = Nil    // List[String] = List()

// three elements that end with a Nil element
val xs = 1 :: 2 :: 3 :: Nil   // List(1, 2, 3)

// this is an error, because it does not end with a Nil
val xs = 1 :: 2 :: 3          // error

// prepending a `1` to a `List(2, 3)`
val xs = 1 :: List(2, 3)      // List(1, 2, 3)
```

The `::` method and `Nil` value have their roots in the Lisp programming language, where lists like this are heavily used. An important thing about `List` is that when you add elements to it, it’s intended to be used in a manner where you always _prepend_ elements to it, like this:

```scala
val a = List(3)  // List(3)
val b = 2 :: a   // List(2, 3)
val c = 1 :: b   // List(1, 2, 3)
```





