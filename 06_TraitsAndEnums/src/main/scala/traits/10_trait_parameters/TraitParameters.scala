package r10_trait_parameters

// pp. 201
package t1 {
  trait Pet(val name: String)

  // a class can extend a trait with a parameter
  class Dog(override val name: String) extends Pet(name):
    override def toString = s"dog name: $name"

  @main def t1 =
    val d = Dog("Fido")
    println(d)

  // later in your code ...
  class SiberianHusky(override val name: String) extends Dog(name)
  class Cat extends Pet("Morris"):
    override def toString = s"Cat: $name"

  @main def t2 =
    val c = Cat()
    println(c)
}

// p. 202
package t2 {
  trait Pet(val name: String)
  trait FeatheredPet extends Pet
  class Bird(override val name: String) extends Pet(name), FeatheredPet:
    override def toString = s"bird name: $name"
  @main def createNewBird =
    val b = Bird("Tweety")
}

// p. 202
package t3_discussion {
  trait Pet(name: String):
    override def toString = s"Pet: $name"
  trait FeatheredPet extends Pet

  // `override` is not needed on these parameters
  class Bird(val name: String) extends Pet(name), FeatheredPet:
    override def toString = s"Bird: $name"
  class Dog(val name: String) extends Pet(name):
    override def toString = s"Dog: $name"
  class SiberianHusky(override val name: String) extends Dog(name)

  // this will not compile
  // class Cat extends Pet("Morris"):
  //     override def toString = s"Cat: $name"
}

// pp. 203-204
package t4 {
  trait A(val a: String):
    println(s"A: $a")
  trait B extends A:
    println(s"B: $a")
  trait C:
    println(s"C")

  class D(override val a: String) extends A(a), B, C
  class E(override val a: String) extends C, B, A(a)

  @main def traitParamsInitOrder =
    val d = D("D")
    val e = E("E")

}
