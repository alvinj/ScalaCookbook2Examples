package r10_intersection_types

import com.alvinalexander.simpletest.SimpleTest.*

// pp. 703-704
package t1 {
  trait A:
    def a = "a"
  trait B:
    def b = "b"
  trait C:
    def c = "c"

  def handleABC(x: A & B & C): Unit =
    println(x.a)
    println(x.b)
    println(x.c)
    println("")

  @main def tests =
    class D extends A, B, C
    val d = D()
    handleABC(d)

    class BCA extends B, C, A
    class CAB extends C, A, B

    // i use 'new' here to make this code easier to read:
    handleABC(BCA())
    handleABC(CAB())

    True(d.isInstanceOf[A])
    True(d.isInstanceOf[B])
    True(d.isInstanceOf[C])

    val b = BCA()
    True(b.isInstanceOf[A])
    True(b.isInstanceOf[B])
    True(b.isInstanceOf[C])

    val c = CAB()
    True(c.isInstanceOf[A])
    True(c.isInstanceOf[B])
    True(c.isInstanceOf[C])

}

// pp. 704-705
package t2 {
  trait HasLegs:
    def run(): Unit
  trait HasWings:
    def flapWings(): Unit

  class Pterodactyl extends HasLegs, HasWings:
    def flapWings()       = println("Flapping my wings")
    def run()             = println("I’m trying to run")
    override def toString = "Pterodactyl"

  class Dog extends HasLegs:
    def run()             = println("I’m running")
    override def toString = "Dog"

  // returns a union type
  def getThingWithLegsOrWings(i: Int): HasLegs | HasWings =
    if i == 1 then Pterodactyl() else Dog()

  // returns an intersection type
  def getThingWithLegsAndWings(): HasLegs & HasWings =
    Pterodactyl()

  @main def unionAndIntersection =

    // union type
    val d1                     = getThingWithLegsOrWings(0)
    val p1: HasLegs | HasWings = getThingWithLegsOrWings(1)

    // intersection type
    val p2                     = getThingWithLegsAndWings()
    val p3: HasLegs & HasWings = getThingWithLegsAndWings()

    // these True/NotTrue tests use my SimpleTest library.
    // they all evaluate to 'true'.
    True(d1.isInstanceOf[Dog])
    False(d1.isInstanceOf[Pterodactyl])

    True(p1.isInstanceOf[Pterodactyl])
    True(p1.isInstanceOf[HasLegs])
    True(p1.isInstanceOf[HasWings])
    False(p1.isInstanceOf[Dog])

    // p2 and p3 are the same, so the p3 tests aren’t shown
    True(p2.isInstanceOf[Pterodactyl])
    True(p2.isInstanceOf[HasLegs])
    True(p2.isInstanceOf[HasWings])
    True(p2.isInstanceOf[HasLegs & HasWings])

}
