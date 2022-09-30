package r14_match_vs_instanceOf

sealed trait SentientBeing
case class Person(name: String, age: Int) extends SentientBeing

sealed trait FourLeggedAnimal extends SentientBeing
case class Dog(name: String) extends FourLeggedAnimal

// later in the code ...
def printInfo(sb: SentientBeing) = sb match
    case Person(name, age) =>
        println(s"Person: $name is $age years old")
    case Dog(name) =>
        println(s"Dog’s name is $name")

@main def useMatchInsteadOfInstanceOf = 
    printInfo(Person("Fred Flintstone", 41))
    printInfo(Dog("Dino"))
