# Recipe 13.6, Flattening a List of Lists with flatten


Use `flatten` to convert a list of lists into a single list:

```scala
val lol = List(
    List(1,2),
    List(3,4)
)
```

Calling `flatten` method creates one new list:

```scala
val x = lol.flatten   // x: List(1, 2, 3, 4)
```

`flatten` isn’t limited to a `List`, here’s a `Vector`:

```scala
// create a Vector containing other Vectors
val a = Vector(Vector(1,2), Vector(3,4))

// flatten it
val b = a.flatten   // b: Vector(1, 2, 3, 4)
```


## Discussion

In a social-networking application, you might do the same thing with a list of your friends, and their friends:

```scala
val myFriends = List("Adam", "David", "Frank")
val adamsFriends = List("Nick K", "Bill M")
val davidsFriends = List("Becca G", "Kenny D", "Bill M")
val franksFriends: List[String] = Nil
val friendsOfFriends = List(adamsFriends, davidsFriends, franksFriends)
```

Because `friendsOfFriends` is a list of lists, you can use `flatten` to create a unique list of the friends of your friends:

```scala
List(
    List("Nick K", "Bill M"), 
    List("Becca G", "Kenny D", "Bill M"), 
    List()
)

val uniqueFriendsOfFriends = friendsOfFriends.flatten.distinct

// result:
// uniqueFriendsOfFriends: List[String] = List(Nick K, Bill M, Becca G, Kenny D)
```


## flatten with Seq[Option]

`flatten` is useful when you have a list of `Option` values:

```scala
// example 1
val x = Vector(Some(1), None, Some(3), None)   // x: Vector[Option[Int]]
val y = x.flatten                              // y: Vector(1, 3)

// example 2
List( Some(1), None,   Some(2) ).flatten   // List(1, 2)
List( List(1), List(), List(2) ).flatten   // List(1, 2)
```


## Combining map and flatten with flatMap

If you ever need to call `map` on a sequence followed by `flatten`, you can use `flatMap` instead:

```scala
val nums = List("1", "2", "three", "4", "one hundred")

import scala.util.{Try,Success,Failure}
def makeInt(s: String): Option[Int] = Try(Integer.parseInt(s.trim)).toOption
```

Calculate the sum of the strings in that list (that properly convert to integers) using `map` followed by `flatten`:

```scala
// use map + flatten
nums.map(makeInt).flatten   // List(1, 2, 4)

// or use flatMap
nums.flatMap(makeInt)   // List(1, 2, 4)
```

This always makes me think that this method should be called “map flat” instead.





