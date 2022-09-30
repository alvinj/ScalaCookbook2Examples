package r10_pizzastore

// pp. 309-310
trait PizzaServiceInterface:
  def addTopping(p: Pizza, t: Topping): Pizza
  def removeTopping(p: Pizza, t: Topping): Pizza
  def removeAllToppings(p: Pizza): Pizza

  def updateCrustSize(p: Pizza, cs: CrustSize): Pizza
  def updateCrustType(p: Pizza, ct: CrustType): Pizza

import utils.ListUtils.dropFirstMatch

trait PizzaService extends PizzaServiceInterface:
  def addTopping(p: Pizza, t: Topping): Pizza =
    val newToppings = p.toppings :+ t
    p.copy(toppings = newToppings)

  def removeTopping(p: Pizza, t: Topping): Pizza =
    val newToppings = dropFirstMatch(p.toppings, t)
    p.copy(toppings = newToppings)

  def removeAllToppings(p: Pizza): Pizza =
    val newToppings = Seq[Topping]()
    p.copy(toppings = newToppings)

  def updateCrustSize(p: Pizza, cs: CrustSize): Pizza =
    p.copy(crustSize = cs)

  def updateCrustType(p: Pizza, ct: CrustType): Pizza =
    p.copy(crustType = ct)

end PizzaService

// p. 313+
trait PizzaPricerTrait:
  // this base trait references the DAO interface
  def pizzaDao: PizzaDaoInterface

  def calculatePizzaPrice(p: Pizza): BigDecimal =
    // the key thing here is the use of `pizzaDao`
    val crustSizePrice: BigDecimal =
      pizzaDao.getCrustSizePrices()(p.crustSize)
    val crustTypePrice: BigDecimal =
      pizzaDao.getCrustTypePrices()(p.crustType)
    val toppingPrices: Seq[BigDecimal] =
      for
        topping <- p.toppings
        toppingPrice = pizzaDao.getToppingPrices()(topping)
      yield toppingPrice
    val totalToppingPrice: BigDecimal = toppingPrices.reduce(_ + _) // sum
    val totalPrice: BigDecimal =
      crustSizePrice + crustTypePrice + totalToppingPrice
    totalPrice

  // other price-related functions ...

end PizzaPricerTrait

object DevPizzaPricerService extends PizzaPricerTrait:
  val pizzaDao = DevPizzaDao // dev environment
