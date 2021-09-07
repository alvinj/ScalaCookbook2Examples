# Recipe 24.2, Using Immutable Variables and Collections


`ArrayBuffer` leaves you open to evil mutation:

```scala
def evilMutator(people: ArrayBuffer[Person]) =
    people.clear()
```

By changing to a `Seq`, `List`, or `Vector`, the following code won’t even compile:

```scala
def evilMutator(people: Seq[Person]) =
    // ERROR - won’t compile
    people.clear()
```



## Using val + mutable, and var + immutable

As an example of the first approach, the current Akka `FSM` class (_scala.akka.actor.FSM_) defines several mutable collection fields as private `val` fields, like this:

```scala
private val timers = mutable.Map[String, Timer]()

// some time later ...
timers -= name
timers.clear()
```

An approach I used on a teaching project is a variation of this theme:

```scala
enum Topping { case Cheese, Pepperoni, Mushrooms } 

class Pizza:
    private val _toppings = collection.mutable.ArrayBuffer[Topping]()
    def toppings = _toppings.toSeq
    def addTopping(t: Topping): Unit =  _toppings += t
    def removeTopping(t: Topping): Unit = _toppings -= t
```





