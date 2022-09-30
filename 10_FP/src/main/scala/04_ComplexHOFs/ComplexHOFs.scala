package r04_complex_hofs

import com.alvinalexander.simpletest.SimpleTest.*

// pp. 289-290
// create a method that takes a function parameter
package t1 {
  def exec(callback: Int => Unit) =
    // invoke the function we were given, giving it an Int parameter
    callback(1)

  val plusOneF         = (i: Int) => println(i + 1)
  def plusOneM(i: Int) = println(i + 1)

  val plusTenF         = (i: Int) => println(i + 10)
  def plusTenM(i: Int) = println(i + 10)

  @main def test =
    exec(plusOneF) // 2
    exec(plusOneM) // 2
    exec(plusTenF) // 11
    exec(plusTenM) // 11
}

// p. 291
package t2 {
  def executeXTimes(callback: () => Unit, numTimes: Int): Unit =
    for i <- 1 to numTimes do callback()

  val sayHelloF   = () => println("Hello")
  def sayHelloM() = println("Hello")

  @main def test =
    executeXTimes(sayHelloF, 3)
    executeXTimes(sayHelloM, 3)
}

// pp. 291-292
package t3 {
  def executeAndPrint(f: (Int, Int) => Int, x: Int, y: Int): Unit =
    val result = f(x, y)
    println(result)

  val sumF                 = (x: Int, y: Int) => x + y
  def sumM(x: Int, y: Int) = x + y

  val multiplyF                 = (x: Int, y: Int) => x * y
  def multiplyM(x: Int, y: Int) = x * y

  @main def test =
    // the functions
    executeAndPrint(sumF, 2, 9)      // prints 11
    executeAndPrint(multiplyF, 3, 9) // prints 27
    // the methods
    executeAndPrint(sumM, 2, 9)      // prints 11
    executeAndPrint(multiplyM, 3, 9) // prints 27
}

// p. 292
package t4 {
  // 1 - define the method
  def exec(callback: (Any, Any) => Unit, x: Any, y: Any): Unit =
    callback(x, y)

  // 2 - define a function to pass in
  def printTwoThings(a: Any, b: Any): Unit =
    println(a)
    println(b)

  case class Person(name: String)

  // 3 - pass the function and some parameters to the method
  @main def test =
    exec(printTwoThings, "Hello", Person("Dave"))

}
