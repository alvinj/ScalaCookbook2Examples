# Recipe 12.4, Deleting Elements from a List (or ListBuffer)


Use methods like `filter`, `take`, `drop`, etc., to filter the elements in a `List`, and methods like `-=`, `--=`, and `remove` to delete elements in a `ListBuffer`.


## List

A `List` is immutable ... filter out the elements you don’t want:

```scala
val a = List(5, 1, 4, 3, 2)

val b = a.filter(_ > 2)   // b: List(5, 4, 3)
val b = a.take(2)         // b: List(5, 1)
val b = a.drop(2)         // b: List(4, 3, 2)
val b = a diff List(1)    // b: List(5, 4, 3, 2)
```

Can also use a `var`:

```scala
var x = List(5, 1, 4, 3, 2)
x = x.filter(_ > 2)       // x: List(5, 4, 3)
```


## ListBuffer

If you’re going to be modifying a list frequently, it can be better to use a `ListBuffer`:

```scala
// create a ListBuffer
import scala.collection.mutable.ListBuffer
val x = ListBuffer(1, 2, 3, 4, 1, 2, 3, 4)
    // result: x: scala.collection.mutable.ListBuffer[Int] = 
    // ListBuffer(1, 2, 3, 4, 1, 2, 3, 4)
```

Delete one element at a time by value using `-=`:

```scala
x -= 2                   // x: ListBuffer(1, 3, 4, 1, 2, 3, 4)
```

Delete two or more elements by value using `--=`:

```scala
val x = ListBuffer(1, 2, 3, 4, 5, 6)

// 1, 2, and 3 are removed:
x --= Seq(1,2,3)         // x: ListBuffer(4, 5, 6)

// nothing matched, so nothing removed:
x --= Seq(8, 9)          // x: ListBuffer(4, 5, 6)
```

Use `remove` to delete elements by index position:

```scala
val x = ListBuffer(1, 2, 3, 4, 5, 6)

// remove the 0th element
val a = x.remove(0)      // a=1, x=ListBuffer(2, 3, 4, 5, 6)

// remove three elements, starting from index 1. this `remove`
// method does not return a value.
x.remove(1, 3)           // x: ListBuffer(2, 6)

// be aware that `remove` can throw an exception
x.remove(100)            // java.lang.IndexOutOfBoundsException
```



