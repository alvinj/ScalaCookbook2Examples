package r06_2

package foo

class ClassA:
  import scala.util.Random // inside ClassA
  def printRandom =
    val r = Random()

class ClassB:
  val b = 1
  // the import is not visible here, so this line won’t compile:
  // val r = Random()
