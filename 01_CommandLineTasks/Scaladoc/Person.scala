package com.acme.foo

/**
 * A class to represent a ''human being''.
 *
 * Specify the `name`, `age`, and `weight` when creating a new `Person`,
 * then access the fields like this:
 * {{{
 * val p = Person("Al", 42, 200.0)
 * p.name
 * p.age
 * p.weight
 * }}}
 *
 * Did you know: The [[com.acme.foo.Employee]] extends this class.
 *
 * @constructor Create a new person with a `name`, `age`, and `weight`.
 * @param name The person's name.
 * @param age The person's age.
 * @param weight The person's weight.
 * @author Alvin Alexander
 * @version 1.0
 * @todo Add more functionality.
 * @see See [[https://alvinalexander.com alvinalexander.com]] for more information.
 */
@deprecated("The `weight` field is going away", "1.0")
class Person (var name: String, var age: Int, var weight: Double):

  /**
   * @constructor This is an auxiliary constructor. Just need a `name` here.
   */
  def this(name: String) = this(name, 0, 0.0)


  /**
   * @return Returns a greeting based on the `name` field.
   */
  def greet = s"Hello, my name is $name"

end Person


/**
 * @constructor Create a new `Employee` by specifying their `name`, `age`, 
 * and `role`.
 * @param name The employee's name.
 * @param age The employee's age.
 * @param role The employee's role in the organization.
 * @example val e = Employee("Al", 42, "Developer")
 */
class Employee(name: String, age: Int, role: String) extends Person(name, age, 0):

  /**
   * @throws boom Throws an Exception 100% of the time, be careful.
   */
  @throws(classOf[Exception])
  def boom = throw Exception("boom")

  /**
   * @return Returns a greeting based on the `other` and `name` fields.
   * @param other The name of the person we're greeting.
   */
  override def greet(other: String) = s"Hello $other, my name is $name"

end Employee



