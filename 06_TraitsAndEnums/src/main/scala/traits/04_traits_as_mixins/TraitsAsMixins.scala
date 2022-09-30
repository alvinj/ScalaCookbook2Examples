package r04_traits_as_mixins

// p. 187
package t1 {
  trait HasTail:
    def wagTail()  = println("Tail is wagging")
    def stopTail() = println("Tail is stopped")

  trait Pet:
    def speak() = println("Yo")
    def comeToMaster(): Unit // abstract

  class Dog(val name: String) extends Pet, HasTail:
    def comeToMaster() = println("Woo-hoo, I'm coming!")

  class Cat(val name: String) extends Pet, HasTail:
    def comeToMaster()   = println("That’s not gonna happen.")
    override def speak() = println("meow")

  @main def traitsAsMixins4A =
    val d = Dog("Zeus")
    d.speak()
    d.comeToMaster()
    val c = Cat("Morris")
    c.speak()
    c.comeToMaster()
}

package t2 {
  trait HasLegs
  trait HasTail
  trait MansBestFriend
  class Pet(val name: String)

  @main def traitsAsMixins4B =
    val zeus = new Pet("Zeus") with MansBestFriend with HasTail with HasLegs
    val cat  = new Pet("Morris") with HasTail with HasLegs
}
