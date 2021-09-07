# Recipe 12.7, Making ArrayBuffer Your “Go To” Mutable Sequence

Declare an `ArrayBuffer` without initial elements by specifying the type it contains, and then add elements later:

```scala
import scala.collection.mutable.ArrayBuffer
val a = ArrayBuffer[String]()

a += "Ben"     // a: ArrayBuffer(Ben)
a += "Jerry"   // a: ArrayBuffer(Ben, Jerry)
a += "Dale"    // a: ArrayBuffer(Ben, Jerry, Dale)
```

Common ways to add elements to an `ArrayBuffer`:

```scala
import scala.collection.mutable.ArrayBuffer

// initialize with elements
val characters = ArrayBuffer("Ben", "Jerry")

// add one element
characters += "Dale"

// add multiple elements with any IterableOnce type
characters ++= List("Gordon", "Harry")
characters ++= Vector("Andy", "Big Ed")

// another way to add multiple elements
characters.appendAll(List("Laura", "Lucy"))

// `characters` now contains these strings:
ArrayBuffer(Ben, Jerry, Dale, Gordon, Harry, Andy, Big Ed, Laura, Lucy)
```

A few ways to _prepend_ elements to an `ArrayBuffer`:

```scala
val a = ArrayBuffer(10)   // a: ArrayBuffer[Int] = ArrayBuffer(10)
a.prepend(9)              // a: ArrayBuffer(9, 10)
a.prependAll(Seq(7,8))    // a: ArrayBuffer(7, 8, 9, 10)

// `+=:` is an alias for `prepend`, `++=:` is an alias for `prependAll`
6 +=: a                   // a: ArrayBuffer(6, 7, 8, 9, 10)
List(4,5) ++=: a          // a: ArrayBuffer(4, 5, 6, 7, 8, 9, 10)
```


## Discussion

A few ways to update `ArrayBuffer` elements in place:

```scala
import scala.collection.mutable.ArrayBuffer

// creates an ArrayBuffer[Char]
val a = ArrayBuffer.range('a', 'f')   // a: ArrayBuffer(a, b, c, d, e)

a.update(0, 'A')                      // a: ArrayBuffer(A, b, c, d, e)
a(2) = 'C'                            // a: ArrayBuffer(A, b, C, d, e)

a.patchInPlace(0, Seq('X', 'Y'), 2)   // a: ArrayBuffer(X, Y, C, d, e)
a.patchInPlace(0, Seq('X', 'Y'), 3)   // a: ArrayBuffer(X, Y, d, e)
a.patchInPlace(0, Seq('X', 'Y'), 4)   // a: ArrayBuffer(X, Y)
```




