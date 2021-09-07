# Recipe 13.9, Splitting Sequences into Subsets

Use the `groupBy`, `splitAt`, `partition`, or `span` methods to partition a sequence into subsequences.


## groupBy

`groupBy`:

```scala
val xs = List(15, 10, 5, 8, 20, 12)

val groups = xs.groupBy(_ > 10)
    // Map(false -> List(10, 5, 8), true -> List(15, 20, 12))

val listOfTrues = groups(true)     // List(15, 20, 12)
val listOfFalses = groups(false)   // List(10, 5, 8)
```

Demonstrate how _many_ lists may be created by `groupBy`:

```scala
val xs = List(1, 3, 11, 12, 101, 102)

// you can also use 'scala.math.log10' for this algorithm
def groupBy10s(i: Int): Int =
    assert(i > 0)
    if i < 10 then 1
    else if i < 100 then 10
    else 100

xs.groupBy(groupBy10s)   // result: HashMap(
                         //     1 -> List(1, 3),
                         //     10 -> List(11, 12),
                         //     100 -> List(101, 102)
                         // )
```


## splitAt, partition, span

`splitAt`:

```scala
val xs = List(15, 5, 20, 10)

val ys = xs.splitAt(1)   // ys: (List(15), List(5, 20, 10))
val ys = xs.splitAt(2)   // ys: (List(15, 5), List(20, 10))
```

`partition` and `span`:

```scala
val xs = List(15, 5, 25, 20, 10)

val ys = xs.partition(_ > 10)   // ys: (List(15, 25, 20), List(5, 10))
val ys = xs.partition(_ < 25)   // ys: (List(15, 5, 20, 10), List(25))

val ys = xs.span(_ < 20)        // ys: (List(15, 5), List(25, 20, 10))
val ys = xs.span(_ > 10)        // ys: (List(15), List(5, 25, 20, 10))
```

When a tuple-2 of sequences is returned, its two sequences can be accessed like this:

[subs=+quotes]
....
scala> *val (a,b) = xs.partition(_ > 10)*
val a: List[Int] = List(15, 20)
val b: List[Int] = List(5, 10)
....


## sliding

`sliding(size,step)`:

```scala
val a = Vector(1, 2, 3, 4, 5)

// size = 2
val b = a.sliding(2).toList     // b: List(Array(1, 2), Array(2, 3),
                                //         Array(3, 4), Array(4, 5))

// size = 2, step = 2
val b = a.sliding(2,2).toList   // b: List(Vector(1, 2), Vector(3, 4),
                                //         Vector(5))

// size = 2, step = 3
val b = a.sliding(2,3).toList   // b: List(Vector(1, 2), Vector(4, 5))
```

As shown, `sliding` works by passing a “sliding window” over the original sequence, returning sequences of a length given by `size`.


## unzip

`unzip`:

```scala
val listOfTuple2s = List((1,2), ('a','b'))

val x = listOfTuple2s.unzip        // (List(1, a),List(2, b))
```

Given a list of couples, you can `unzip` the list:

```scala
val couples = List(("Wilma", "Fred"), ("Betty", "Barney"))

val (women, men) = couples.unzip   // val men: List(Fred, Barney)
                                   // val women: List(Wilma, Betty)
```

`unzip` is the opposite of `zip`:

```scala
val couples = women zip men        // List((Wilma,Fred), (Betty,Barney))
```






