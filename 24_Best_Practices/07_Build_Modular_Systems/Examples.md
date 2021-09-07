# Recipe 24.7, Building Modular Systems


## An example

A dog is an animal:

```scala
trait Animal
```

A dog is an animal with a tail:

```scala
abstract class AnimalWithTail(tailColor: Color) extends Animal
```

Since a dog has a tail, what kind of behaviors can a tail have?:

```scala
trait DogTailServices:
    def wagTail = ???
    def lowerTail = ???
    def raiseTail = ???
```

Control what classes the trait can be mixed into with a self-type:

```scala
trait DogTailServices:
    // implementers must be a sub-type of AnimalWithTail
    this: AnimalWithTail =>

    def wagTail = ???
    def lowerTail = ???
    def raiseTail = ???
```

With its methods:

```scala
trait DogTailServices:
    this: AnimalWithTail =>
    def wagTail() = println("wagging tail")
    def lowerTail() = println("lowering tail")
    def raiseTail() = println("raising tail")
```

A dog has a mouth:

```scala
trait DogMouthServices:
    this: AnimalWithTail =>    
    def bark() = println("bark!")
    def lick() = println("licking")
```


### Create a module

Create a module as an implementation of an Irish Setter:

```scala
object IrishSetter extends
    AnimalWithTail(Color.red), 
    DogTailServices, 
    DogMouthServices
```

```scala
import java.awt.Color

IrishSetter.wagTail()   // wagging tail
IrishSetter.bark()      // bark!
```




