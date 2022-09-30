package r07_constructor_params_extending_class

import com.alvinalexander.simpletest.SimpleTest.*

// p. 150
package t1 {
  class Person(val name: String)
  class Employee(name: String, val age: Int) extends Person(name):
    override def toString = s"$name is $age years old"

  @main def test =
    val joe = Employee("Joe", 33)
    Equals(joe.toString, "Joe is 33 years old")
}

// p. 150
package t2 {
  class Person(var name: String)

  // note the use of '_name' here
  class Employee(_name: String, var age: Int) extends Person(_name):
    override def toString = s"$name is $age"

  @main def test =
    val joe = Employee("Joe", 33)
    Equals(joe.toString, "Joe is 33")
}

// pp. 151-152
package t3 {
  class Person(var name: String):
    override def toString = s"$name"

  class Employee private extends Person(""):
    var age = 0
    println("Employee constructor called")
    override def toString = s"$name is $age"

  object Employee:
    def apply(_name: String, _age: Int) =
      val e = new Employee()
      e.name = _name
      e.age = _age
      e

  @main def test =
    val e = Employee("Joe", 33)
    e
    Equals(e.toString, "Joe is 33")

    // update and verify the name and age fields
    e.name = "Fred"
    e.age = 34
    e // "Fred is 34 years old"
    Equals(e.name, "Fred")
}
