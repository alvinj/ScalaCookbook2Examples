package r12_canequal_typeclass

import com.alvinalexander.simpletest.SimpleTest.*

// p. 708
// Derive CanEqual
package t1 {
  case class Person(name: String) derives CanEqual
  @main def tests =
    import scala.language.strictEquality
    True(Person("Al") == Person("Al"))
    False(Person("Joe") == Person("Fred"))
}

// p. 708
// given+CanEqual approach
package t2 {
  case class Person(name: String)
  given CanEqual[Person, Person] = CanEqual.derived

  @main def tests =
    import scala.language.strictEquality
    True(Person("Al") == Person("Al"))
}

// p. 709
package t3 {
  import scala.language.strictEquality

  case class Customer(name: String):
    def canEqual(a: Any) = a.isInstanceOf[Customer] || a.isInstanceOf[Employee]
    override def equals(that: Any): Boolean =
      if !canEqual(that) then return false
      that match
        case c: Customer => this.name == c.name
        case e: Employee => this.name == e.name
        case _           => false

  case class Employee(name: String):
    def canEqual(a: Any) = a.isInstanceOf[Employee] || a.isInstanceOf[Customer]
    override def equals(that: Any): Boolean =
      if !canEqual(that) then return false
      that match
        case c: Customer => this.name == c.name
        case e: Employee => this.name == e.name
        case _           => false

  given CanEqual[Customer, Customer] = CanEqual.derived
  given CanEqual[Employee, Employee] = CanEqual.derived
  given CanEqual[Customer, Employee] = CanEqual.derived // Customer to Employee
  given CanEqual[Employee, Customer] = CanEqual.derived // Employee to Customer

  @main def tests =
    val c = Customer("Barb S.")
    val e = Employee("Barb S.")
    True(c == c)
    True(e == e)
    True(c == e)
    True(e == c)
    False(Customer("Cheryl") == Employee("Barb"))
}

// p. 710
package t4 {
  given CanEqual[String, Int] = CanEqual.derived
  given CanEqual[Int, String] = CanEqual.derived

  @main def tests =
    False(2 == "2") // but the comparison is allowed
    False("2" == 2) // also allowed
}
