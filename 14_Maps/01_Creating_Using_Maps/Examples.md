# Recipe 14.1, Creating and Using Maps

## Immutable map

Create an immutable map:

```scala
val a = Map(
    "AL" -> "Alabama",
    "AK" -> "Alaska"
)
```

That example creates an immutable `Map` with type `[String, String]`, meaning that both the _key_ and _value_ have type `String`.

Specify elements to be added, updated, and removed, while assigning the resulting `Map` to a new variable:

```scala
// create a map
val a = Map(1 -> "a")

// adding elements
val b = a + (2 -> "b")
val c = b ++ Map(3 -> "c", 4 -> "d")
val d = c ++ List(5 -> "e", 6 -> "f")

// current result:
d: Map[Int, String] = HashMap(5 -> e, 1 -> a, 6 -> f, 2 -> b, 3 -> c, 4 -> d)

// update where the key is 1
val e = d + (1 -> "AA")
    // e: HashMap(5 -> e, 1 -> AA, 6 -> f, 2 -> b, 3 -> c, 4 -> d)

// update multiple elements at one time
val f = e ++ Map(2 -> "BB", 3 -> "CC")
val g = f ++ List(2 -> "BB", 3 -> "CC")
    // g: HashMap(5 -> e, 1 -> AA, 6 -> f, 2 -> BB, 3 -> CC, 4 -> d)

// remove elements by specifying the keys to remove
val h = g - 1
val i = h -- List(1, 2, 3)
    // i: HashMap(5 -> e, 6 -> f, 4 -> d)
```

Or use a `var` and one variable name:

```scala
// reassign each update to the 'map' variable
var map = Map(1 -> "a")
map = map + (2 -> "b")   // map: Map(1 -> a, 2 -> b)
map = map + (3 -> "c")   // map: Map(1 -> a, 2 -> b, 3 -> c)
```



## Mutable map

To create a _mutable_ map, either use an import statement to bring it into scope, or specify the full path to the _scala.collection.mutable.Map_ class when you create an instance:

```scala
// create an empty, mutable map
val m = scala.collection.mutable.Map[Int, String]()

// adding by assignment
m(1) = "a"                       // m: HashMap(1 -> a)

// adding with += and ++=
m += (2 -> "b")                  // m: HashMap(1 -> a, 2 -> b)
m ++= Map(3 -> "c", 4 -> "d")    // m: HashMap(1 -> a, 2 -> b, 3 -> c, 4 -> d)
m ++= List(5 -> "e", 6 -> "f")   // m: HashMap(1 -> a, 2 -> b, 3 -> c, 4 -> d, 
                                 //            5 -> e, 6 -> f)

// remove elements by specifying the keys to remove
m -= 1            // m: HashMap(2 -> b, 3 -> c, 4 -> d, 5 -> e, 6 -> f)
m --= List(2,3)   // m: HashMap(4 -> d, 5 -> e, 6 -> f)

// updating
m(4) = "DD"       // m: HashMap(4 -> DD, 5 -> e, 6 -> f)
```



## Discussion

Because you can also declare a tuple-2 as `("AL", "Alabama")`, you may also see maps created like this:

```scala
val states = Map(
    ("AL", "Alabama"),
    ("AK", "Alaska")
)
```

If you want to make it clear that you’re using a _mutable_ map, one technique is to give the mutable `Map` class an alias when you import it:

```scala
import scala.collection.mutable.{Map => MMap}

// MMap is really scala.collection.mutable.Map
val m = MMap(1 -> 'a')   // m: Map[Int, Char] = HashMap(1 -> a)
m += (2 -> 'b')          // m: HashMap(1 -> a, 2 -> b)
```









