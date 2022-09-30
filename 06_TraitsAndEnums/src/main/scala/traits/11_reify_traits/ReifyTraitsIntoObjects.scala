package r11_reify

import com.alvinalexander.simpletest.SimpleTest.*

// p. 204
package t1 {
    trait AddService:
        def add(a: Int, b: Int) = a + b
    object AddService extends AddService

    @main def reifyAddService1 =
        import AddService.*
        println(add(1,1))
}


// p. 205
package t2 {
    trait AddService:
        def add(a: Int, b: Int) = a + b

    trait MultiplyService:
        def multiply(a: Int, b: Int) = a * b

    object MathService extends AddService, MultiplyService

    @main def reifyMathService2 =
        import MathService.*
        Equals(add(1,1),      2)
        Equals(multiply(2,2), 4)
}


// pp. 206-208
package t3 {
    
    // p. 207
    enum CrustSize:
        case Small, Medium, Large

    enum CrustType:
        case Thin, Thick, Regular

    enum Topping:
        case Cheese, Pepperoni, Olives

    case class Pizza(
        crustSize: CrustSize,
        crustType: CrustType,
        toppings: Seq[Topping]
    )

    case class Order(items: Seq[Pizza])

    trait OrderDao:
        def addItem(p: Pizza): Unit
        def getItems: Seq[Pizza]

    // p. 208
    trait MockOrderDao extends OrderDao:
        import scala.collection.mutable.ArrayBuffer
        private val items = ArrayBuffer[Pizza]()

        def addItem(p: Pizza) = items += p
        def getItems: Seq[Pizza] = items.toSeq

    trait Logger:
        def log(s: String): Unit

    trait ConsoleLogger extends Logger:
        def log(s: String) = println(s"LOG: $s")

    trait OrderController:
        this: Logger =>          // declares a self-type
        def orderDao: OrderDao   // an abstract method

        def addItemToOrder(p: Pizza) = orderDao.addItem(p)
        def printReceipt(): Unit =
            val receipt = generateReceipt
            println(receipt)
            log(receipt)   // from Logger
        
        // this is an example of a private method in a trait
        private def generateReceipt: String =
            val items: Seq[Pizza] = for p <- orderDao.getItems yield p
            s"""
            |YOUR ORDER
            |----------
            |${items.mkString("\n")}""".stripMargin

    end OrderController

    // p. 206
    @main def pizzaModuleDemo =
        import CrustSize.*
        import CrustType.*
        import Topping.*
        
        // create some mock objects for testing
        object MockOrderDao extends MockOrderDao
        object MockOrderController extends OrderController, ConsoleLogger:
            // specify a concrete instance of an OrderDao, in this case a 
            // MockOrderDao for this MockOrderController
            val orderDao = MockOrderDao

        val smallThinCheesePizza = Pizza(
            Small, Thin, Seq(Cheese)
        )

        val largeThickWorks = Pizza(
            Large, Thick, Seq(Cheese, Pepperoni, Olives)
        )

        MockOrderController.addItemToOrder(smallThinCheesePizza)
        MockOrderController.addItemToOrder(largeThickWorks)
        MockOrderController.printReceipt()
}




