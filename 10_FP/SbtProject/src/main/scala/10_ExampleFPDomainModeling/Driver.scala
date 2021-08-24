package r10_pizzastore

import Topping.*, CrustSize.*, CrustType.*


// pp. 309-310
package t1 {
    @main def pizzaServiceMain =
        // PizzaService is a trait that extend PizzaServiceInterface
        import PizzaService.*
        object PizzaService extends PizzaService

        // an initial pizza
        val p = Pizza(Medium, Regular, Seq(Cheese))

        // demonstrating the PizzaService functions
        val p1 = addTopping(p, Pepperoni)
        val p2 = addTopping(p1, Mushrooms)
        val p3 = updateCrustType(p2, Thick)
        val p4 = updateCrustSize(p3, Large)
    
        // this is *not* a functional approach to printing output.
        // result:
        // Pizza(LargeCrustSize,ThickCrustType,List(Cheese, Pepperoni, Mushrooms))
        println(p4)
}


// p. 315
package t2 {
    @main def pizzaPricingMain =

        object PizzaService extends PizzaService
        import PizzaService.*
        import DevPizzaPricerService.*

        // create a pizza
        val p = Pizza(
            Medium,
            Regular,
            Seq(Cheese, Pepperoni, Mushrooms)
        )

        // determine the pizza price
        val pizzaPrice = calculatePizzaPrice(p)

        // print the pizza and its price (in a non-functional way)
        println(s"Pizza: $p")
        println(s"Price: $pizzaPrice")

}

