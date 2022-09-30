package r15

import com.alvinalexander.simpletest.SimpleTest.*

// pp. 176-177
// the case class. note that it uses 'var' fields, which is
// something you don’t do in FP, but can do in OOP.
case class Person(var name: String, var age: Int)

// the companion object
object Person:
  def apply()             = new Person("<no name>", 0)
  def apply(name: String) = new Person(name, 0)

// these examples are rearranged slightly to be easier to
// understand and follow here.
@main def caseClassTest =
  // corresponds to apply()
  val a = Person()

  // verify the setter methods work
  a.name = "Sarah Bannerman"
  a.age = 38
  True(a.toString == "Person(Sarah Bannerman,38)")
  println(a)

  // corresponds to 'apply(name: String)'
  val b = Person("Sarah Bracknell")
  Equals(b.toString, "Person(Sarah Bracknell,0)")

  // corresponds to the case class constructor
  val c = Person("Sarah Bracknell", 32)
  Equals(c.toString, "Person(Sarah Bracknell,32)")
