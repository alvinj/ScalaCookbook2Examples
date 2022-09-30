package r06_3

def printRandom = {
  import scala.util.Random
  val r1 = Random() // this works, as expected
}
// this won’t compile, because the import statement is
// inside the previous block:
// val r2 = Random()       //error: not found: type Random
