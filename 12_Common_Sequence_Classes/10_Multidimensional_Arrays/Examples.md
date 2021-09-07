# Recipe 12.10, Creating Multidimensional Arrays


Two main solutions:

1. Use _Array.ofDim_ to create a multidimensional array ... you need to know the number of rows and columns at creation time.
2. Create arrays of arrays as needed.


===== (1) Using Array.ofDim

Use the `Array.ofDim` method to create the array you need:

```scala
val rows = 2
val cols = 3

val a = Array.ofDim[String](rows, cols)

// `a` now looks like this:
Array[Array[String]] = Array(
    Array(null, null, null), 
    Array(null, null, null)
)
```

Add elements to it:

```scala
a(0)(0) = "a"   // row 1
a(0)(1) = "b"
a(0)(2) = "c"
a(1)(0) = "d"   // row 2
a(1)(1) = "e"
a(1)(2) = "f"
```

Access the elements using parentheses:

```scala
a(0)(0)   // a
a(1)(2)   // f
```

Iterate with a `for` loop:

[subs=+quotes]
....
for
    i <- 0 until rows
    j <- 0 until cols
do
    println(s"($i)($j) = ${a(i)(j)}")

// (0)(0) = a
// (0)(1) = b
// (0)(2) = c
// (1)(0) = d
// (1)(1) = e
// (1)(2) = f
....

Here’s a three-dimensional array:

```scala
val x, y, z = 10
val a = Array.ofDim[Int](x,y,z)
for
    i <- 0 until x
    j <- 0 until y
    k <- 0 until z
do
    println(s"($i)($j)($k) = ${a(i)(j)(k)}")
```



===== (2) Using an array of arrays

Another approach is to create an array whose elements are arrays:

```scala
val a = Array(
    Array("a", "b", "c"),
    Array("d", "e", "f")
)

val x = a(0)      // x: Array(a, b, c)
val x = a(1)      // x: Array(d, e, f)
val x = a(0)(0)   // x: a
```

This lets you create “ragged” arrays:

```scala
val a = Array(
    Array("a", "b", "c"),
    Array("d", "e"),
    Array("f")
)
```

You can also declare your variable as a `var` and create the same array in multiple steps:

```scala
var arr = Array(Array("a", "b", "c"))
arr ++= Array(Array("d", "e"))
arr ++= Array(Array("f"))

// result:
Array(Array(a, b, c), Array(d, e), Array(f))
```








