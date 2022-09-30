package r04_companion_objects

// pp. 221-222
package t1 {
  // Pizza class
  class Pizza(var crustType: String):
    override def toString = s"Crust type is $crustType"

  // companion object
  object Pizza:
    val CRUST_TYPE_THIN  = "THIN" // static fields
    val CRUST_TYPE_THICK = "THICK"
    def getPrice         = 0.0    // static method

  @main def testCompanions =
    println(Pizza.CRUST_TYPE_THIN) // THIN
    println(Pizza.getPrice)        // 0.0

    val p = Pizza(Pizza.CRUST_TYPE_THICK)
    println(p) // "Crust type is THICK"

}

// pp. 222
package t2 {

  class Foo:
    private val secret = 42

  object Foo:
    // access the private class field `secret`
    def doubleFoo(foo: Foo) = foo.secret * 2

  @main def fooMain =
    val f = Foo()
    println(Foo.doubleFoo(f)) // prints 84
}

// pp. 223
package t3 {

  class Foo:
    // access the private object field `obj`
    def printObj = println(s"I can see ${Foo.obj}")

  object Foo:
    private val obj = "Foo’s object"

  @main def fooMain =
    val f = Foo()
    f.printObj // prints "I can see Foo’s object"

}
