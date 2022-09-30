package r05_apply_as_constructor

import com.alvinalexander.simpletest.SimpleTest.*

// p. 224
package t1 {

  class Person private (val name: String):
    override def toString = name

  object Person:
    // the “constructor”
    def apply(name: String): Person = new Person(name)

  @main def applyTest =
    val regina = Person("Regina")
    val a = List(
      Person("Regina"),
      Person("Robert")
    )
    a.foreach(println)

    // p. 225
    val p1 = Person("Fred Flintstone")
    val p2 = Person.apply("Fred Flintstone")
    True(p1.name == p2.name)
}

// pp. 224-225
package t2 {

  class Person private (var name: String, var age: Int):
    override def toString = s"$name is $age years old"

  object Person:
    // three ways to build a Person
    def apply(): Person                       = new Person("", 0)
    def apply(name: String): Person           = new Person(name, 0)
    def apply(name: String, age: Int): Person = new Person(name, age)

  @main def moreApplyTests =
    println(Person())             //  is 0 years old
    println(Person("Regina"))     // Regina is 0 years old
    println(Person("Robert", 22)) // Robert is 22 years old

}

// p. 225
package t3 {

  class Person private (var name: String, var age: Int):
    override def toString = s"$name is $age years old"

  object Person:
    def apply(t: (String, Int)) = new Person(t(0), t(1))
    // the '(String, Int)*' syntax here means, “Zero or more
    // two-element tuples, where the first element must be
    // a String and the second element must be an Int.”
    def apply(ts: (String, Int)*) =
      for t <- ts yield new Person(t(0), t(1))

  @main def moreApplyTests =
    // create a person from a tuple
    val john = Person(("John", 30))
    println(john)

    // create multiple people using a variable number of tuples
    val peeps = Person(
      ("Barb", 33),
      ("Cheryl", 31)
    )
    peeps.foreach(println)
}
