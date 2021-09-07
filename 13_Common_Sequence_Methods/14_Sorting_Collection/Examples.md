# Recipe 13.14, Sorting a Collection


## Solution

### Using sorted, sortWith, and sortBy with immutable sequences

`sorted` can sort collections with type `Double`, `Int`, `String`, and any other type that has an implicit _scala.math.Ordering_:

```scala
List(10, 5, 8, 1, 7).sorted          // List(1, 5, 7, 8, 10)
List("dog", "mouse", "cat").sorted   // List(cat, dog, mouse)
```

`sortWith` lets you provide your own sorting algorithm:

```scala
// short form: sorting algorithm uses '_' references
Vector("dog", "mouse", "cat").sortWith(_ < _)     // Vector(cat, dog, mouse)
Vector("dog", "mouse", "cat").sortWith(_ > _)     // Vector(mouse, dog, cat)

// long form: sorting algorithm uses a tuple-2
Vector(10, 5, 8, 1, 7).sortWith((a,b) => a < b)   // Vector(1, 5, 7, 8, 10)
Vector(10, 5, 8, 1, 7).sortWith((a,b) => a > b)   // Vector(10, 8, 7, 5, 1)
```

Your sorting function needs to take two parameters, and can be as simple or complicated as it needs to be:

```scala
def sortByLength(s1: String, s2: String): Boolean =
    // simulate the need for a longer method
    println(s"comparing $s1 & $s2")
    s1.length > s2.length
```

Then use it by passing it into the `sortWith` method:

```scala
val a = List("dog", "mouse", "cat").sortWith(sortByLength)

// result:
comparing mouse & dog
comparing cat & mouse
comparing mouse & cat
comparing cat & dog
comparing dog & cat
a: List[String] = List(mouse, dog, cat)
```


`sortBy`:

```scala
val a = List("peach", "apple", "pear", "fig")
val b = a.sortBy(s => s.length)             // b: List(fig, pear, peach, apple)

// the Scaladoc shows an example like this that works “because scala.Ordering 
// will implicitly provide an Ordering[Tuple2[Int, Char]]”
val b = a.sortBy(s => (s.length, s.head))   // b: List(fig, pear, apple, peach)

// a way to sort from the longest to the shortest string, and then
// by the string
val a = List("fin", "fit", "fig", "pear", "peas", "peach", "peat")
val b = a.sortBy(s => (-s.length, s))
    // b: List(peach, pear, peas, peat, fig, fin, fit)
```


## Using sortInPlace, sortInPlaceWith, and sortInPlaceBy with mutable sequences

With *mutable* sequences like `ArrayBuffer` use the `sortInPlace`, `sortInPlaceWith`, and `sortInPlaceBy` methods. If the data type in your sequence supports sorting with an implicit `Ordering` or by implementing `Ordered`, `sortInPlace` is a direct solution:

```scala
import scala.collection.mutable.ArrayBuffer

val a = ArrayBuffer(3,5,1)
a.sortInPlace   // a: ArrayBuffer(1, 3, 5)

val b = ArrayBuffer("Mercedes", "Hannah", "Emily")
b.sortInPlace   // b: ArrayBuffer(Emily, Hannah, Mercedes)
```

`sortInPlaceWith` is similar to `sortWith`:

```scala
import scala.collection.mutable.ArrayBuffer
val a = ArrayBuffer(3,5,1)
a.sortInPlaceWith(_ < _)   // a: ArrayBuffer(1, 3, 5)
a.sortInPlaceWith(_ > _)   // a: ArrayBuffer(5, 3, 1)
```

`sortInPlaceBy` works like `sortBy`:

```scala
import scala.collection.mutable.ArrayBuffer
val a = ArrayBuffer("kiwi", "apple", "fig")
a.sortInPlaceBy(_.length)   // a: ArrayBuffer(fig, kiwi, apple)
```



## Discussion

### Having an implicit Ordering

If the type a sequence is holding doesn’t have an implicit `Ordering`, you won’t be able to sort it with `sorted`:

```scala
class Person(val name: String):
    override def toString = name

val dudes = List(
    Person("Bill"),
    Person("Al"),
    Person("Adam")
)
```

If you try to sort this list in the REPL, you’ll see an error stating that the `Person` class doesn’t have an implicit `Ordering`:

```scala
scala> dudes.sorted
1 |dudes.sorted
  |            ^
  |            No implicit Ordering defined for B
  |            where:    B is a type variable with constraint >: Person
  |            I found:
  |                scala.math.Ordering.ordered[A](/* missing
  |                */summon[scala.math.Ordering.AsComparable[B]])
  |            But no implicit values were found that match type
  |            scala.math.Ordering.AsComparable[B].
```

You can’t use `sorted` with the `Person` class as it’s written, so one solution is to write an anonymous function to sort the `Person` elements by the `name` field using `sortWith`:

```scala
dudes.sortWith(_.name < _.name)   // List(Adam, Al, Bill)
dudes.sortWith(_.name > _.name)   // List(Bill, Al, Adam)
```


### Providing an explicit Ordering with sorted

If your class doesn’t have an _implicit_ `Ordering`, one solution is to provide an _explicit_ `Ordering`:

```scala
class Person(val firstName: String, val lastName: String):
    override def toString = s"$firstName $lastName"
```

Trying to sort a list of `Person` instances with `sorted` won’t work:

```scala
val peeps = List(
    Person("Jessica", "Day"),
    Person("Nick", "Miller"),
    Person("Winston", "Bishop")
)

scala> peeps.sorted
1 |peeps.sorted
  |            ^
  |No implicit Ordering defined for B ... (long error message) ...
```

A solution is to create an explicit `Ordering` that works with `Person`:

```scala
object LastNameOrdering extends Ordering[Person]:
    def compare(a: Person, b: Person) = a.lastName compare b.lastName
```

Now when you use `LastNameOrdering` with `sorted`, sorting works as desired:

```scala
scala> val sortedPeeps = peeps.sorted(LastNameOrdering)

// result:
val sortedPeeps: List[Person] = List(Winston Bishop, Jessica Day, Nick Miller)
```

Another approach is to declare `LastNameOrdering` with the `implicit` keyword, and then call `sorted`:

```scala
implicit object LastNameOrdering extends Ordering[Person]:
    def compare(a: Person, b: Person) = a.lastName compare b.lastName

val sortedPeeps = peeps.sorted
    // sortedPeeps: List(Winston Bishop, Jessica Day, Nick Miller)
```


### Mix in the Ordered trait to use sorted

If you want to use the `Person` class with the `sorted` method, another solution is to mix the `Ordered` trait into `Person`, and then implement the `Ordered` trait’s abstract `compare` method:

```scala
class Person (var name: String) extends Ordered[Person]:

    override def toString = name

    // return 0 if the same, negative if this < that, positive if this > that
    def compare (that: Person): Int =
        // depends on the definition of `==` for String
        if this.name == that.name then
            0
        else if this.name > that.name then
            1
        else
            -1
```

Now this new `Person` class can be used with `sorted`:

```scala
val dudes = List(
    Person("Bill"),
    Person("Al"),
    Person("Adam")
)

val x = dudes.sorted   // x: List(Adam, Al, Bill)
```

Because this `compare` algorithm only compares two `String` values, it could have been written like this:

```scala
def compare (that: Person) = this.name.compare(that.name)
```

The `Ordered` trait lets you compare object instances directly in your code:

```scala
val bill = Person("Bill")
val al = Person("Al")
val adam = Person("Adam")

if adam > bill then println(adam) else println(bill)
```

This works because the `Ordered` trait implements the `<=`, `<`, `>`, and `>=` methods, and they call your `compare` method to make those comparisons.



