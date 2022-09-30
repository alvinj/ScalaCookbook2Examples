package r01_choosing_options

// p. 133
enum Topping:
  case Cheese, Pepperoni, Sausage, Mushrooms, Onions

enum CrustSize:
  case Small, Medium, Large

enum CrustType:
  case Regular, Thin, Thick

import Topping.*
import CrustSize.*
import CrustType.*

package t1_fp {

  case class Pizza(
    crustSize: CrustSize,
    crustType: CrustType,
    toppings: Seq[Topping]
  )

  case class Customer(
    name: String,
    phone: String,
    address: Address
  )

  case class Address(
    street1: String,
    street2: Option[String],
    city: String,
    state: String,
    postalCode: String
  )

  case class Order(
    pizzas: Seq[Pizza],
    customer: Customer
  )

  trait PizzaServiceInterface:
    def addTopping(p: Pizza, t: Topping): Pizza
    def removeTopping(p: Pizza, t: Topping): Pizza
    def removeAllToppings(p: Pizza): Pizza
    def updateCrustSize(p: Pizza, cs: CrustSize): Pizza
    def updateCrustType(p: Pizza, ct: CrustType): Pizza

  trait PizzaService extends PizzaServiceInterface:
    def addTopping(p: Pizza, t: Topping): Pizza =
      // the 'copy' method comes with a case class
      val newToppings = p.toppings :+ t
      p.copy(toppings = newToppings)
    // there are about two lines of code for each of these
    // methods, so all of that code is not repeated here:
    def removeTopping(p: Pizza, t: Topping): Pizza      = ???
    def removeAllToppings(p: Pizza): Pizza              = ???
    def updateCrustSize(p: Pizza, cs: CrustSize): Pizza = ???
    def updateCrustType(p: Pizza, ct: CrustType): Pizza = ???
  end PizzaService

  object PizzaService extends PizzaService

}

// p. 135+
package t2_oop {

  import scala.collection.mutable.ArrayBuffer

  // p. 136: product hierarchy
  // a Product may have methods to determine its cost, sales price,
  // and other details
  sealed trait Product
  // each class may have additional attributes and methods
  class Beverage     extends Product
  class Cheesesticks extends Product

  // p. 135 (notice that it extends Product)
  class Pizza(
    var crustSize: CrustSize,
    var crustType: CrustType,
    val toppings: ArrayBuffer[Topping]
  ) extends Product:
    def addTopping(t: Topping): Unit =
      toppings += t
    def removeTopping(t: Topping): Unit =
      toppings -= t
    def removeAllToppings(): Unit =
      toppings.clear()
  end Pizza

  type Money = BigDecimal
  class Order:
    private val lineItems             = ArrayBuffer[Product]()
    def addItem(p: Product): Unit     = ???
    def removeItem(p: Product): Unit  = ???
    def getItems(): Seq[Product]      = ???
    def getPrintableReceipt(): String = ???
    def getTotalPrice(): Money        = ???
  end Order

  // p. 136
  // because of all the `???` instances, i can’t go too far with this code,
  // but this gives you an idea of how it works
  @main def orderTest =
    // usage:
    val o = Order()
    o.addItem(Pizza(Small, Thin, ArrayBuffer(Cheese, Pepperoni)))
    o.addItem(Cheesesticks())

}
