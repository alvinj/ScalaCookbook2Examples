# Recipe 24.5, Eliminating null Values from Your Code


## Initialize var fields with Option, not null

When you write code in an OOP style, you might be tempted to write some code like this:

```scala
case class Address(city: String, state: String, zip: String)

class User(var email: String, var password: String):
    var firstName: String = _
    var lastName: String = _
    var address: Address = _
```

The `User` class is bad news, because `firstName`, `lastName`, and `address` are all declared to be `null` ... the preferred approach:

```scala
class User(var email: String, var password: String):
    var firstName = None: Option[String]
    var lastName = None: Option[String]
    var address = None: Option[Address]
```

Now create a `User` like this:

```scala
val u = User("al@example.com", "secret")
```

Later:

```scala
u.firstName = Some("Al")
u.lastName = Some("Alexander")
u.address = Some(Address("Talkeetna", "AK", "99676"))
```

Later, access the fields like this:

```scala
u.address.foreach { a =>
    println(a.city)
    println(a.state)
    println(a.zip)
}
```

or this:

```scala
println(firstName.getOrElse("<not assigned>"))
```

Use an `Option` in a constructor when a field is optional:

```scala
case class Address(
    street1: String,
    street2: Option[String],
    city: String,
    state: String,
    zip: String
)
```



## Don’t return null from methods

With an `Option`, your function signatures should look like this:

```scala
def doSomething: Option[String] = ???
def makeInt(s: String): Option[Int] = ???
def lookupPerson(name: String): Option[Person] = ???
```

For instance, when reading a file:

```scala
def readTextFile(filename: String): Option[List[String]] =
    try
        Some(io.Source.fromFile(filename).getLines.toList)
    catch
        case e: Exception => None


// or this
import scala.util.{Try, Success, Failure}

def readTextFile(filename: String): Try[List[String]] =
    Try(io.Source.fromFile(filename).getLines.toList)



## Null objects

```scala
trait Animal:
    def makeSound(): Unit

class Dog extends Animal:
    def makeSound(): Unit = println("woof")

class NullAnimal extends Animal:
    def makeSound(): Unit = ()   // just returns Unit
```


## Converting a null into an Option, or something else

`getName` converts a result from a Java method that may be `null` and returns an `Option[String]` instead:

```scala
def getName(): Option[String] =
    val name = javaPerson.getName()
    if name == null then None else Some(name)
```






