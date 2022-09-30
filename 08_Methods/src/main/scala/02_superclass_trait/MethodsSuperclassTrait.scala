package r02_method_super

// p. 240
package t1:
  class AnimalWithLegs:
    def walk() = println("I’m walking")
    def run()  = println("I’m running")

  class Dog extends AnimalWithLegs:
    def walkThenRun() =
      walk()
      run()

  @main def walkThenRun =
    val d = Dog()
    d.walkThenRun()

// p. 240-241
package t2:

  class AnimalWithLegs:
    // the superclass 'walk' method
    def walk() = println("Animal is walking")

  class Dog extends AnimalWithLegs:
    // the subclass 'walk' method
    override def walk() =
      super.walk()              // invoke the superclass method (if desired)
      println("Dog is walking") // add your own body

  @main def superMethod =
    val d = Dog()
    d.walk()

// pp. 241-242
package t3:

  trait Human:
    def yo = "Human"

  trait Mother extends Human:
    override def yo = "Mother"

  trait Father extends Human:
    override def yo = "Father"

  class Child extends Human, Mother, Father:
    def printSuper  = super.yo
    def printMother = super[Mother].yo
    def printFather = super[Father].yo
    def printHuman  = super[Human].yo

  @main def superWithmultipleTraits =
    val c = Child()
    println(c.printSuper)  // Father
    println(c.printMother) // Mother
    println(c.printFather) // Father
    println(c.printHuman)  // Human
