package r06_ensure_class_has_method

// p. 193
package t1 {
    trait StarfleetWarpCore:
        this: FederationStarship =>
        // the rest of the trait here ...

    // this compiles, as desired
    trait FederationStarship
    class Enterprise extends FederationStarship, StarfleetWarpCore
    
    class RomulanShip
    // this won’t compile
    // class Warbird extends RomulanShip, StarfleetWarpCore
}


// pp. 193-194
package t2 {
    trait HasLegs
    trait CanRun:
        this: HasLegs =>

    class Dog extends HasLegs, CanRun: 
        def whatAmI(): Unit =
        if this.isInstanceOf[Dog] then println("Dog")
        if this.isInstanceOf[HasLegs] then println("HasLegs")
        if this.isInstanceOf[CanRun] then println("CanRun")

    @main def discussion =
        val d = Dog()
        d.whatAmI()
}


package t3 {
    trait HasLegs:
        def numLegs = 0
    trait CanRun:
        this: HasLegs =>
        def run() = println(s"I have $numLegs legs and I’m running!")

    class Dog extends HasLegs, CanRun:
        override val numLegs = 4

    @main def selfTypes = 
        val d = Dog()
        d.run()   // "I have 4 legs and I’m running!"
}


// p. 195
package t4 {
    trait WarpCore:
        this: FederationStarship & WarpCoreEjector & FireExtinguisher =>
        // more trait code here ...
    class FederationStarship
    trait WarpCoreEjector
    trait FireExtinguisher
    
    // this compiles as desired
    class Enterprise extends 
        FederationStarship, WarpCore, WarpCoreEjector, FireExtinguisher
}


