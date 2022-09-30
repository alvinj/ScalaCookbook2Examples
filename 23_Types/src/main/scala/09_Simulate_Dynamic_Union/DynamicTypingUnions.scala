package r09_dynamic_typing_unions

import com.alvinalexander.simpletest.SimpleTest.*

// p. 701
package t1 {
  // Perl version of "true"
  def isTrue(a: Int | String): Boolean = a match
    case 0   => false
    case "0" => false
    case ""  => false
    case _   => true

  @main def tests =
    // true
    println(isTrue(0))
    println(isTrue("0"))
    println(isTrue(""))

    // false
    println(isTrue(1))
    println(isTrue("1"))
}

// p. 702
package t2 {

  class Person
  class Planet
  class BeachBall

  def isTrue(a: Int | String | Person | Planet | BeachBall): Boolean = a match
    // add more tests here for the other types
    case 0   => false
    case "0" => false
    case ""  => false
    case _   => true

  @main def tests =
    // true
    println(isTrue(0))
    println(isTrue("0"))
    println(isTrue(""))

    // false
    println(isTrue(1))
    println(isTrue("1"))
}

// p. 702
package t3 {
  def aFunction(): Int | String =
    val x = scala.util.Random.nextInt(100)
    if (x < 50) then x else s"string: $x"

  @main def tests =
    val x = aFunction()
    println(x)

    val y: Int | String = aFunction()
    println(y)

}

// p. 703
package t4 {
  // create a union type from two literal types
  type Bool = "True" | "False"

  // a function to use the union type. notice that you don’t need
  // the catch-all “case _ =>” case.
  def handle(b: Bool): Unit = b match
    case "True"  => println("true")
    case "False" => println("false")

  @main def tests =
    handle("True")
    handle("False")
    // handle("Fudge")  // error, won’t compile

    // this also works
    val t: Bool = "True"
    val f: Bool = "False"
    // val x: Bool = "Fudge"  // error, won’t compile
}
