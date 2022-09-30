package r01_method_takes_generic_type

// p. 677
package t1 {
  // this version works only on a Seq[String]
  def randomName(names: Seq[String]): String =
    val randomNum = util.Random.nextInt(names.length)
    names(randomNum)

  @main def test =
    val names  = Seq("Aleka", "Christina", "Emily", "Hannah")
    val winner = randomName(names)
    println(winner)
}

package t2 {
  // a generic version of the same method
  def randomElement[A](seq: Seq[A]): A =
    val randomNum = util.Random.nextInt(seq.length)
    seq(randomNum)

  @main def test =
    // this generic method works with String, Int, Double, Char, and more
    println(randomElement(Seq("Emily", "Hannah", "Aleka", "Christina")))
    println(randomElement(List(1, 2, 3)))
    println(randomElement(List(1.0, 2.0, 3.0)))
    println(randomElement(Vector.range('a', 'z')))
}
