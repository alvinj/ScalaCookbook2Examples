# Recipe 13.11, Finding the Unique Elements in a Sequence


## Solution

Either call the `distinct` method on the sequence, or call `toSet`:

```scala
val x = Vector(1, 1, 2, 3, 3, 4)

val y = x.distinct   // Vector(1, 2, 3, 4)
val z = x.toSet      // Set(1, 2, 3, 4)
```


## Discussion

To use these approaches with your own classes, you’ll need to implement the `equals` and `hashCode` methods:

```scala
case class Person(firstName: String, lastName: String)

val dale1 = Person("Dale", "Cooper")
val dale2 = Person("Dale", "Cooper")
val ed = Person("Ed", "Hurley")
val list = List(dale1, dale2, ed)

// correct solution: only one Dale Cooper appears in this result:
val uniques = list.distinct   // List(Person(Dale,Cooper), Person(Ed,Hurley))
val uniques = list.toSet      // Set(Person(Dale,Cooper), Person(Ed,Hurley))
```


### This fails, as expected

Without an `equals` method, this attempt fails:

```scala
class Person(firstName: String, lastName: String):
    override def toString = s"$firstName $lastName"

val list = List(
    Person("Dale", "Cooper"),
    Person("Dale", "Cooper"),
    Person("Ed", "Hurley")
)

val uniques = list.distinct

// result:
val uniques: List[Person] = List(Dale Cooper, Dale Cooper, Ed Hurley)
```










