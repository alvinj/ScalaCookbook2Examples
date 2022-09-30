package r02_passing_functions_around

import com.alvinalexander.simpletest.SimpleTest.*

// TODO: TEST ALL OF THESE

// pp. 282-283
package t1 {
  @main def tests =

    // [1a] a "double" function
    val double = (i: Int) => i * 2

    // [1b] double some numbers
    Equals(double(2), 4)
    Equals(double(3), 6)

    // [1c] use double with map
    val list = List.range(1, 5)
    Equals(list.map(double), List(2, 4, 6, 8))

    // [2a] a "length" function
    val length = (s: String) => s.length

    // [2b] use 'length' with map
    val lengths = List("Mercedes", "Hannah", "Emily").map(length)
    Equals(lengths, List(8, 6, 5))
}

// p. 283
package t2_examples {
  // val f = (i: Int) => { i % 2 == 0 }  // sometimes easier to read with parentheses
  // val f = (i: Int) => i % 2 == 0      // same function without parentheses

  // val isEven: (Int) => Boolean = i => { i % 2 == 0 }
  // val isEven: Int => Boolean = i => { i % 2 == 0 }
  // val isEven: Int => Boolean = i => i % 2 == 0
  // val isEven: Int => Boolean = _ % 2 == 0

  // implicit approach
  // val add = (x: Int, y: Int) => { x + y }
  // val add = (x: Int, y: Int) => x + y

  // explicit approach
  // val add: (Int, Int) => Int = (x, y) => { x + y }
  // val add: (Int, Int) => Int = (x, y) => x + y

  val addThenDouble: (Int, Int) => Int = (x, y) =>
    val a = x + y
    2 * a
}

// “Using a def method like a val function”.
// p. 284
package t3 {
  // several different ways to write this method
  // def isEvenMethod(i: Int) = i % 2 == 0
  // def isEvenMethod(i: Int) = { i % 2 == 0 }
  // def isEvenMethod(i: Int): Boolean = i % 2 == 0
  // def isEvenMethod(i: Int): Boolean = { i % 2 == 0 }

  @main def test =
    val list = List.range(1, 10)

    // [1] use a method where a function is expected (filter)
    def isEvenMethod(i: Int) =
      i % 2 == 0
    val x = list.filter(isEvenMethod)
    Equals(x, List(2, 4, 6, 8))

    // [2] or pass a function into filter
    val isEvenFunction = (i: Int) => i % 2 == 0
    val y              = list.filter(isEvenFunction)
    Equals(y, List(2, 4, 6, 8))
}

// “Assigning an existing function/method to a function variable.”
// p. 285
package t4 {
  @main def test =
    val c = scala.math.cos
    Equals(c(0), 1.0)

    val square = scala.math.pow(_, 2)
    Equals(square(3), 9.0)
    Equals(square(4), 16.0)
}

// “Storing functions in a Map”
// p. 286
package t5 {
  def add(i: Int, j: Int)      = i + j
  def multiply(i: Int, j: Int) = i * j

  // store the functions in a Map
  val functions = Map(
    "add"      -> add,
    "multiply" -> multiply
  )

  @main def test =
    // get a function out of the Map and use it
    val f = functions("add")
    Equals(f(2, 2), 4)
}
