package r02_collections

import scala.jdk.CollectionConverters.*

// p. 652
class ScalaClass:
  val strings = List("a", "b")

// p. 653
class ScalaClass2:

  // the first example
  val ints = Seq(1, 2, 3)

  // make that code easier to access on the Java side
  val jIntegers: Seq[java.lang.Integer] = ints.map(i => i: java.lang.Integer)
