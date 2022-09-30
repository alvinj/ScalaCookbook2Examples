package r08_fluent

// pp. 250-251
package t1 {

  class Person:
    protected var _fname = ""
    protected var _lname = ""

    def setFirstName(firstName: String): this.type = // note `this.type`
      _fname = firstName
      this

    def setLastName(lastName: String): this.type = // note `this.type`
      _lname = lastName
      this
  end Person

  class Employee extends Person:
    protected var employeeNumber = 0

    def setEmployeeNumber(num: Int): this.type =
      this.employeeNumber = num
      this

    override def toString = s"$_fname, $_lname, $employeeNumber"
  end Employee

  @main def fluentTest =
    val employee = Employee()

    // use the fluent methods
    employee
      .setFirstName("Maximillion")
      .setLastName("Alexander")
      .setEmployeeNumber(2)
    println(employee)

}

// pp. 251-252
package t2 {
  enum CrustSize:
    case Small, Medium, Large

  enum CrustType:
    case Regular, Thin, Thick

  enum Topping:
    case Cheese, Pepperoni, Mushrooms

  import CrustSize.*, CrustType.*, Topping.*

  final class Pizza:
    import scala.collection.mutable.ArrayBuffer

    private val toppings  = ArrayBuffer[Topping]()
    private var crustSize = Medium
    private var crustType = Regular

    def addTopping(topping: Topping) =
      toppings += topping
      this

    def setCrustSize(crustSize: CrustSize) =
      this.crustSize = crustSize
      this

    def setCrustType(crustType: CrustType) =
      this.crustType = crustType
      this

    def print() =
      println(s"crust size: $crustSize")
      println(s"crust type: $crustType")
      println(s"toppings:   $toppings")
  end Pizza

  @main def fluentPizza =
    val pizza = Pizza()
    pizza
      .setCrustSize(Large)
      .setCrustType(Thin)
      .addTopping(Cheese)
      .addTopping(Mushrooms)
      .print()

}
