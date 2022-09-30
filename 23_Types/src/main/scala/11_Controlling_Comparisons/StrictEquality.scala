package r11_strict_equality

import com.alvinalexander.simpletest.SimpleTest.*

// pp. 705-706
package t1 {
  class Person(var name: String)
  class Customer(var name: String)

  @main def tests =
    val p = Person("Kim")
    val c = Customer("Kim")
    False(p == c) // note that the comparison is allowed
}

// p. 706
package t2 {
  import scala.language.strictEquality

  case class Dog(name: String)
  case class Cat(name: String)

  @main def tests =
    val d = Dog("Fido")
    val c = Cat("Morris")

    // this line will not compile with strictEquality enabled.
    // “Values of types Dog and Cat cannot be compared with == or !=”
    // println(d == c)
}

// pp. 706-707
package t3 {
  import scala.language.strictEquality

  case class Person(name: String)

  @main def tests =
    println("test")
    // with strictEquality imported, this won’t compile either
    // Person("Ken") == Person("Ken")
}

// p. 707
package t4 {
  import scala.language.strictEquality
  case class Person(name: String) derives CanEqual

  @main def tests =
    // this now works, and results in `true`
    True(Person("Ken") == Person("Ken"))
}
