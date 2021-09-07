# Recipe 12.8, Deleting Array and ArrayBuffer Elements


## Deleting ArrayBuffer elements

Given this `ArrayBuffer`:

```scala
import scala.collection.mutable.ArrayBuffer
val x = ArrayBuffer('a', 'b', 'c', 'd', 'e')
```

Remove one or more elements by value with `-=` and `--=`:

```scala
// remove one element
x -= 'a'              // x: ArrayBuffer(b, c, d, e)

// remove multiple elements
x --= Seq('b', 'c')   // x: ArrayBuffer(d, e)
```

As shown, use `--=` to remove multiple elements that are declared in any collection that extends `IterableOnce`:

```scala
val x = ArrayBuffer.range('a', 'f')   // ArrayBuffer(a, b, c, d, e)

x --= Seq('a', 'b')   // x: ArrayBuffer(c, d, e)
x --= Array('c')      // x: ArrayBuffer(d, e)
x --= Set('d')        // x: ArrayBuffer(e)
```

Use `remove` to delete one element by its index in the `ArrayBuffer`, or a series of elements beginning at a starting index:

```scala
val x = ArrayBuffer('a', 'b', 'c', 'd', 'e', 'f')

x.remove(0)           // x: ArrayBuffer(b, c, d, e, f)

// delete three elements, starting at index 1
// (results in deleting c, d, and e)
x.remove(1, 3)        // x: ArrayBuffer(b, f)
```

`clear` removes all the elements from an `ArrayBuffer`:

```scala
val x = ArrayBuffer(1,2,3,4,5)
x.clear               // x: ArrayBuffer[Int] = ArrayBuffer()
```

`clearAndShrink` removes all elements from an `ArrayBuffer` and resizes its internal representation:

```scala
// create and populate an ArrayBuffer
val x = ArrayBuffer.range(1, 1_000_000)

// remove all elements and resize the internal representation
x.clearAndShrink(0)   // x: ArrayBuffer[Int] = ArrayBuffer()
```


## Replacing elements in an Array

The size of an `Array` can’t be changed ... but you can reassign the elements in an `Array`:

```scala
val a = Array("apple", "banana", "cherry")

a(0) = ""     // a: Array("", banana, cherry)
a(1) = null   // a: Array("", null, cherry)
```


## Discussion

With both `Array` and `ArrayBuffer` you can also use the usual functional filtering methods:

```scala
val a = Array(1,2,3,4,5)   // a: Array[Int] = Array(1, 2, 3, 4, 5)

val b = a.filter(_ > 3)    // b: Array(4, 5)
val c = a.take(2)          // c: Array(1, 2)
val d = a.drop(2)          // d: Array(3, 4, 5)
val e = a.find(_ > 3)      // e: Some(4)
val f = a.slice(0, 3)      // f: Array(1, 2, 3)
```







