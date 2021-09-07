# Recipe 13.10, Walking Through a Collection with the reduce and fold Methods

First, create a sample sequence to experiment with:

```scala
val xs = Vector(12, 6, 15, 2, 20, 9)
```

Use `reduceLeft` to calculate the sum of the elements in the sequence:

```scala
val sum = xs.reduceLeft(_ + _)   // 64
```

You can write your anonymous function like this, if you prefer:

```scala
xs.reduceLeft((x,y) => x + y)
```

Product, smallest value, largest value:

```scala
xs.reduceLeft(_ * _)     // 388800
xs.reduceLeft(_ min _)   // 2
xs.reduceLeft(_ max _)   // 20
```

`reduceLeft` works if the element only contains one element:

```scala
List(1).reduceLeft(_ * _)     // 1
List(1).reduceLeft(_ min _)   // 1
List(1).reduceLeft(_ max _)   // 1
```

However, it throws an exception if the sequence it’s given is empty:

```scala
val emptyVector = Vector[Int]()

val sum = emptyVector.reduceLeft(_ + _)
// result: java.lang.UnsupportedOperationException: empty.reduceLeft
```

So, (a) check the collection size before using `reduceLeft`, or (b) use `foldLeft` with a seed value:

```scala
val emptyVector = Vector[Int]()

emptyVector.foldLeft(0)(_ + _)   // 0
emptyVector.foldLeft(1)(_ * _)   // 1
```


## Discussion

Demonstrate how `reduceLeft` works:

```scala
def findMax(x: Int, y: Int): Int = 
    val winner = x max y
    println(s"compared $x to $y, $winner was larger")
    winner

xs.reduceLeft(findMax)

// output:
compared 12 to 6, 12 was larger
compared 12 to 15, 15 was larger
compared 15 to 2, 15 was larger
compared 15 to 20, 20 was larger
compared 20 to 9, 20 was larger
res0: Int = 20
```


## A subtraction algorithm

For example, given this list and `subtract` algorithm:

```scala
val xs = List(1, 2, 3)

def subtract(a: Int, b: Int): Int = 
    println(s"a: $a, b: $b")
    val result = a - b
    println(s"result: $result\n")
    result
```

The REPL demonstrates how `reduceLeft` and `reduceRight` work:

```scala
// first example
scala> xs.reduceLeft(subtract)
a: 1, b: 2
result: -1

a: -1, b: 3
result: -4

val res0: Int = -4


// second example
scala> xs.reduceRight(subtract)
a: 2, b: 3
result: -1

a: 1, b: -1
result: 2

val res1: Int = 2
```


## Bonus: Getting the longest and shortest strings

The type contained in the sequence can be anything you need. For instance, determining the longest or shortest string in a sequence of strings:

```scala
// given a sequence
val peeps = Vector("al", "hannah", "emily", "christina", "aleka")

// longest
peeps.reduceLeft((x,y) => if x.length > y.length then x else y)
res0: String = christina

// shortest
peeps.reduceLeft((x,y) => if x.length < y.length then x else y)
res1: String = al
```


## Bonus: scanLeft and scanRight

Two methods named `scanLeft` and `scanRight` walk through a sequence like `reduceLeft` and `reduceRight`, but they return a sequence instead of a single value. For instance, per its Scaladoc, `scanLeft` “Produces a collection containing cumulative results of applying the operator going left to right.” To understand how it works, create another function with a little debug code in it:

```scala
def product(x: Int, y: Int): Int = 
    val result = x * y
    println(s"multiplied $x by $y to yield $result")
    result
```

Here’s what `scanLeft` looks like when it’s used with that function and a seed value:

```scala
scala> val xs = Vector(1, 2, 3)
xs: Vector[Int] = Vector(1, 2, 3)

scala> xs.scanLeft(10)(product)
multiplied 10 by 1 to yield 10
multiplied 10 by 2 to yield 20
multiplied 20 by 3 to yield 60
res0: Vector[Int] = Vector(10, 10, 20, 60)
```

As shown, like the `map` method, `scanLeft` returns a new sequence, rather than a single value. The `scanRight` method works the same way, but marches through the collection from right to left.



