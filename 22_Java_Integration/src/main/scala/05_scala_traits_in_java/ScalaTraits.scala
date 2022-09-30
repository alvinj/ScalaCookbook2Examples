package r05_scala_traits_in_java

// p. 659, these will be used in the corresponding java code
trait SAddTrait:
  def sum(x: Int, y: Int) = x + y // implemented

trait SMultiplyTrait:
  def multiply(x: Int, y: Int): Int // abstract
