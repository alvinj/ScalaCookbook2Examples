# Recipe 12.5, Creating a Mutable List with ListBuffer

Create a `ListBuffer`, then add and remove elements as desired, and finally convert it to a `List` when finished:

```scala
import scala.collection.mutable.ListBuffer

// create an empty ListBuffer[String]
val b = new ListBuffer[String]()

// add one element at a time to the ListBuffer
b += "a"   // b: ListBuffer(a)
b += "b"   // b: ListBuffer(a, b)
b += "c"   // b: ListBuffer(a, b, c)

// add multiple elements (++= is an alias for addAll)
b ++= List("d", "e", "f")         // b: ListBuffer(a, b, c, d, e, f)
b.addAll(Vector("d", "e", "f"))   // b: ListBuffer(a, b, c, d, e, f, d, e, f)

// remove the first "d"
b -= "d"                          // b: ListBuffer(a, b, c, e, f, d, e, f)

// remove multiple elements specified by another sequence
b --= Seq("e", "f")               // b: ListBuffer(a, b, c, d)

// convert the ListBuffer to a List when you need to
val xs = b.toList                 // xs: List(a, b, c, d)
```



