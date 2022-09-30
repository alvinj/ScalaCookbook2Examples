package r07_partial_functions

import com.alvinalexander.simpletest.SimpleTest.*

// p. 299
package t1 {
  val divide = new PartialFunction[Int, Int] {
    def apply(x: Int)       = 42 / x
    def isDefinedAt(x: Int) = x != 0
  }

  @main def test =
    False(divide.isDefinedAt(0))
    True(divide.isDefinedAt(1))

    val x = if divide.isDefinedAt(1) then Some(divide(1)) else None
    Equals(x, Some(42))
}

// p. 299, a partial function written with a case statement
package t2 {
  val divide2: PartialFunction[Int, Int] =
    case d if d != 0 => 42 / d

  @main def test =
    False(divide2.isDefinedAt(0))
    True(divide2.isDefinedAt(1))

    val x = if divide2.isDefinedAt(1) then Some(divide2(1)) else None
    Equals(x, Some(42))
}

// p. 300
package t3 {
  // converts 1 to "one", etc., up to 5
  val convertLowNumToString = new PartialFunction[Int, String] {
    val nums                = Array("one", "two", "three", "four", "five")
    def apply(i: Int)       = nums(i - 1)
    def isDefinedAt(i: Int) = i > 0 && i < 6
  }
}

// pp. 300-301
package t4 {
  val convert1to5 = new PartialFunction[Int, String] {
    val nums                = Array("one", "two", "three", "four", "five")
    def apply(i: Int)       = nums(i - 1)
    def isDefinedAt(i: Int) = i > 0 && i < 6
  }

  // converts 6 to "six", etc., up to 10
  val convert6to10 = new PartialFunction[Int, String] {
    val nums                = Array("six", "seven", "eight", "nine", "ten")
    def apply(i: Int)       = nums(i - 6)
    def isDefinedAt(i: Int) = i > 5 && i < 11
  }

  @main def test =
    val handle1to10 = convert1to5 orElse convert6to10
    Equals(handle1to10(3), "three")
    Equals(handle1to10(8), "eight")

}

// pp. 301-302
package t5 {
  val divide: PartialFunction[Int, Int] =
    case d: Int if d != 0 =>
      42 / d

  @main def test =
    // List(0,1,2).map(divide)   // MatchError
    val a = List(0, 1, 2).collect(divide)
    Equals(a, List(42, 21))

    val b = List(0, 1, 2)
      .filter(divide.isDefinedAt(_))
      .map(divide)
    Equals(b, List(42, 21))

    val c = List(42, "cat").collect { case i: Int => i + 1 }
    Equals(c, List(43))

    val possibleNums = List(Some(1), None, Some(3), None)
    val d            = possibleNums.collect { case Some(i) => i }
    Equals(d, List(1, 3))

    // tip on p. 302
    Equals(possibleNums.flatten, List(1, 3))
}
