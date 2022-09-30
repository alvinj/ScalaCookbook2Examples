package r03_visibility

import com.alvinalexander.simpletest.SimpleTest.*

// p. 141
package t1 {
  class Person(var name: String)

  @main def varFields =
    val p = Person("Mark Sinclair Vincent")
    Equals(p.name, "Mark Sinclair Vincent")

    p.name = "Vin Diesel"
    Equals(p.name, "Vin Diesel")
}

// p. 141
package t2 {
  class Person(val name: String)
  @main def valFields =
    val p = Person("Jane Doe")
    Equals(p.name, "Jane Doe")

    // this code won’t compile (Reassignment to val name):
    // p.name = "Wilma Flintstone"
}

// p. 142
package t3 {
  // notice that `password` is not declared as a val or var:
  class SuperEncryptor(password: String):
    // `encrypt` increments each Char in a String by 1
    private def encrypt(s: String) = s.map(c => (c + 1).toChar)
    def getEncryptedPassword       = encrypt(password)

  @main def testSuperEncryptor =
    val e = SuperEncryptor("1234")
    // this won’t compile (value password cannot be accessed):
    // e.password
    Equals(e.getEncryptedPassword, "2345")
}

// p. 142
package t4 {
  enum Role:
    case HumanResources, WorkerBee

  import Role.*

  class Employee(var name: String, private var salary: Double):
    def getSalary(r: Role): Option[Double] = r match
      case HumanResources => Some(salary)
      case _              => None

  @main def testPrivateValVar =
    val e = Employee("Steve Jobs", 1)

    // to access the salary field you have to use getSalary
    Equals(e.name, "Steve Jobs")
    Equals(e.getSalary(WorkerBee), None)
    Equals(e.getSalary(HumanResources), Some(1.0))

    // won’t compile (variable salary in class Employee cannot be accessed):
    // e.salary

}

// p. 143
package t5 {
  case class Person(name: String)

  @main def testCaseClass =
    val p = Person("Dale Cooper")
    Equals(p.name, "Dale Cooper")
}
