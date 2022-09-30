package r02_abstract_fields

// pp. 183-184
package t1 {
    trait PizzaTrait:
        def maxNumToppings: Int

    // val
    class SmallPizza1 extends PizzaTrait:
        val maxNumToppings = 4

    // lazy val
    class SmallPizza2 extends PizzaTrait:
        lazy val maxNumToppings =
            // some long-running operation
            Thread.sleep(1_000)
            4

    // var
    class MediumPizza extends PizzaTrait:
        var maxNumToppings = 6

    // def
    class LargePizza extends PizzaTrait:
        def maxNumToppings: Int =
            // some algorithm here
            42
}


// pp. 184-185
package t2 {
    trait Foo:
        def bar: Int   // abstract
        val a = 1      // concrete val
        var b = 2      // concrete var

    trait SentientBeing:
        var uuid = 0   // concrete

    class Person extends SentientBeing:
        uuid = 1

    trait Cat:
        val numLives = 9   // concrete

    class BetterCat extends Cat:
        override val numLives = 10
}



