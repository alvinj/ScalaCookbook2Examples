package r10_pizzastore

import Topping.*, CrustSize.*, CrustType.*

// p. 312
trait PizzaDaoInterface:
  def getToppingPrices(): Map[Topping, BigDecimal]
  def getCrustSizePrices(): Map[CrustSize, BigDecimal]
  def getCrustTypePrices(): Map[CrustType, BigDecimal]

object DevPizzaDao extends PizzaDaoInterface:

  def getToppingPrices(): Map[Topping, BigDecimal] =
    Map(
      Cheese    -> BigDecimal(1), // simulating $1 each
      Pepperoni -> BigDecimal(1),
      Sausage   -> BigDecimal(1),
      Mushrooms -> BigDecimal(1)
    )

  def getCrustSizePrices(): Map[CrustSize, BigDecimal] =
    Map(
      Small  -> BigDecimal(0),
      Medium -> BigDecimal(1),
      Large  -> BigDecimal(2)
    )

  def getCrustTypePrices(): Map[CrustType, BigDecimal] =
    Map(
      Regular -> BigDecimal(0),
      Thick   -> BigDecimal(1),
      Thin    -> BigDecimal(1)
    )

end DevPizzaDao
