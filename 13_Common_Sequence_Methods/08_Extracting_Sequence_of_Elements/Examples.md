# Recipe 13.8, Extracting a Sequence of Elements from a Collection


There are quite a few collection methods you can use to extract a contiguous list of elements from a sequence, including `drop`, `dropWhile`, `head`, `headOption`, `init`, `last`, `lastOption`, `slice`, `tail`, `take`, and `takeWhile`.

Given the following `Vector`:

[source,scala]
----
val x = (1 to 10).toVector
----

`drop`:

[source,scala]
----
val y = x.drop(3)            // y: Vector(4, 5, 6, 7, 8, 9, 10)
----

`dropRight`:

[source,scala]
----
val y = x.dropRight(4)       // y: Vector(1, 2, 3, 4, 5, 6)
----

`dropWhile`:

[source,scala]
----
val y = x.dropWhile(_ < 6)   // y: Vector(6, 7, 8, 9, 10)
----

`take`:

[source,scala]
----
val y = x.take(3)            // y: Vector(1, 2, 3)
----

`takeRight`:

[source,scala]
----
val y = x.takeRight(3)       // y: Vector(8, 9, 10)
----

`takeWhile`:

[source,scala]
----
val y = x.takeWhile(_ < 5)   // y: Vector(1, 2, 3, 4)
----

`slice(from, until)` returns a sequence beginning at the index `from` until the index `until`, not including `until`, and assuming a zero-based index:

[source,scala]
----
val chars = Vector('a', 'b', 'c', 'd')

chars.slice(0,1)   // Vector(a)
chars.slice(0,2)   // Vector(a, b)

chars.slice(1,1)   // Vector()
chars.slice(1,2)   // Vector(b)
chars.slice(1,3)   // Vector(b, c)

chars.slice(2,3)   // Vector(c)
chars.slice(2,4)   // Vector(c, d)
----


## Discussion

More methods! Given this list:

[source,scala]
----
val nums = Vector(1, 2, 3, 4, 5)
----

the comments after the following expressions show the values that are returned by each method:

[source,scala]
----
nums.head         // 1
nums.headOption   // Some(1)
nums.init         // Vector(1, 2, 3, 4)

nums.tail         // Vector(2, 3, 4, 5)
nums.last         // 5
nums.lastOption   // Some(5)
----

As a word of caution, be aware that `head`, `init`, `tail`, and `last` will throw a _java.lang.UnsupportedOperationException_ on empty sequences.






