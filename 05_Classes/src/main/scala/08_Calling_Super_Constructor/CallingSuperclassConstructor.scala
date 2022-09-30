package r08_call_superclass_constructor

// p. 153
package t1 {
  class Pet(var name: String)
  class Dog(name: String) extends Pet(name)
}

// p. 153
package t2 {
  // (1) two-arg primary constructor
  class Pet(var name: String, var age: Int):
    // (2) one-arg auxiliary constructor
    def this(name: String) = this(name, 0)
    override def toString = s"$name is $age years old"

  // calls the Pet one-arg constructor
  class Dog(name: String) extends Pet(name)

  // call the two-arg constructor
  class Dog2(name: String) extends Pet(name, 0)
}

// pp. 153-154
package t3 {
  case class Address(city: String, state: String)
  case class Role(role: String)

  class Person(var name: String, var address: Address):
    // no way for Employee auxiliary constructors to call this constructor
    def this(name: String) =
      this(name, null)
      address = null // don’t use null in the real world

  class Employee(name: String, role: Role, address: Address) extends Person(name, address):
    def this(name: String) =
      this(name, null, null)
    def this(name: String, role: Role) =
      this(name, role, null)
    def this(name: String, address: Address) =
      this(name, null, address)

}
