package r03_trait_like_abstract_class

trait Pet:
    def speak() = println("Yo")   // concrete implementation
    def comeToMaster(): Unit      // abstract method

class Dog extends Pet:
    // no need to implement `speak` if you don’t want to
    def comeToMaster() = println("I'm coming!")

class Cat extends Pet:
    override def speak() = println("meow")
    def comeToMaster() = println("That’s not gonna happen.")

abstract class FlyingPet extends Pet:
    def fly() = println("Woo-hoo, I’m flying!")

@main def testAbstract =
    val d = Dog()
    d.speak()
    d.comeToMaster()
    
    val c = Cat()
    c.speak()
    c.comeToMaster()
