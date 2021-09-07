# Chapter 12: Collections: Common Sequence Classes


## Vector

```scala
val a = Vector(1, 2, 3, 4, 5)
val b = a.filter(_ > 2)   // Vector(3, 4, 5)
val c = a.map(_ * 10)     // Vector(10, 20, 30, 40, 50)
```


## List

```scala
val a = List(1, 2, 3, 4, 5)
val b = a.filter(_ > 2)   // List(3, 4, 5)
val c = a.map(_ * 10)     // List(10, 20, 30, 40, 50)
```


## ArrayBuffer

Vector example, and how you need to reassign the `map` result:

```scala
val x = Vector(1, 2, 3)
val y = x.map(_ * 2)      // y: ArrayBuffer(2, 4, 6)
```

With `ArrayBuffer` you use `mapInPlace` instead of `map`, and it modifies the value in place:

```scala
import collection.mutable.ArrayBuffer
val ab = ArrayBuffer(1, 2, 3)
ab.mapInPlace(_ * 2)   // ab: ArrayBuffer(2, 4, 6)
```




