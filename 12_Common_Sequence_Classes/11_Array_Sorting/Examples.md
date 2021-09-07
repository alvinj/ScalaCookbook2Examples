# Recipe 12.11, Sorting Arrays

If you’re working with an `Array` that holds elements of a type that extend _scala.math.Ordered_, or that have an implicit or explicit `Ordering`, you can sort the `Array` in place using the _scala.util.Sorting.quickSort_ method:

```scala
val fruits = Array("cherry", "apple", "banana")

scala.util.Sorting.quickSort(fruits)
fruits   // Array(apple, banana, cherry)
```

Notice that `quickSort` sorts the `Array` in place ... this example works because the `String` class (via `StringOps`) has an implicit `Ordering`.



## Discussion

This `Person` class won’t work with _Sorting.quickSort_ because it doesn’t provide any information on how the data should be sorted:

```scala
class Person(val firstName: String, val lastName: String):
    override def toString = s"$firstName $lastName"

val peeps = Array(
    Person("Jessica", "Day"),
    Person("Nick", "Miller"),
    Person("Winston", "Bishop"),
    Person("", "Schmidt"),
    Person("Coach", ""),
)
```

Attempting to sort that `Array` results in an error:

```scala
// results in this error: “No implicit Ordering defined for Person”
scala.util.Sorting.quickSort(peeps)
```

The solution is to extend the _scala.math.Ordered_ trait ... or provide an implicit or explicit `Ordering`. An explicit `Ordering`:

```scala
object LastNameOrdering extends Ordering[Person]:
    def compare(a: Person, b: Person) = a.lastName compare b.lastName

scala.util.Sorting.quickSort(peeps)(LastNameOrdering)
    // result: Array(Coach , Winston Bishop, Jessica Day, Nick Miller, Schmidt)
```


### Using a “given” Ordering

First define a `given` value that’s an instance of `Ordering[Person]`:

```scala
given personOrdering: Ordering[Person] with
    def compare(a: Person, b: Person) = a.lastName compare b.lastName
```

Now when you call `quickSort` on the `peeps` array, the result is the same:

```scala
import scala.util.Sorting.quickSort

quickSort(peeps)
// result: peeps: Array[Person] =
// Array(Coach , Winston Bishop, Jessica Day, Nick Miller,  Schmidt)
```

Note that because the `personOrdering` name really isn’t needed in the code, the `given` parameter could have also been declared without a variable name, like this:

```scala
given Ordering[Person] with
    def compare(a: Person, b: Person) = a.lastName compare b.lastName
```




