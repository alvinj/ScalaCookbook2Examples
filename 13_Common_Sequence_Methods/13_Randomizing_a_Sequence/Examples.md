# Recipe 13.13 Randomizing a Sequence


## Solution

To randomize a sequence:

```scala
import scala.util.Random

// List
val xs = List(1,2,3,4,5)
val ys = Random.shuffle(xs)    // 'ys' will be shuffled, like List(4,1,3,2,5)

// also works with other sequences
val x = Random.shuffle(Vector(1,2,3,4,5))   // x: Vector(5,3,4,1,2)
val x = Random.shuffle(Array(1,2,3,4,5))    // x: mutable.ArraySeq(1,3,2,4,5)

import scala.collection.mutable.ArrayBuffer
val x = Random.shuffle(ArrayBuffer(1,2,3,4,5))   // x: ArrayBuffer(4,2,3,1,5)
```

A key to this solution is knowing that shuffle doesn’t randomize the list it’s given; instead it returns a new list that has been randomized (shuffled).



## Discussion

If you just want to get a random element from a list:

```scala
import scala.util.Random

// throws an IllegalArgumentException if `seq` is empty
def getRandomElement[A](seq: Seq[A]): A = 
    seq(Random.nextInt(seq.length))
```

Use this function to get random element from the sequence:

```scala
val randomNumber = getRandomElement(List(1,2,3))
val randomString = getRandomElement(List("a", "b", "c"))
```






