package r05_partially_applied_functions

import com.alvinalexander.simpletest.SimpleTest.*

// p. 293
package t1 {
  val sum    = (a: Int, b: Int, c: Int) => a + b + c
  val addTo3 = sum(1, 2, _)

  @main def test =
    Equals(addTo3(10), 13)
}

// p. 294
package t2 {
  def sum(a: Int, b: Int, c: Int) = a + b + c
  val addTo3                      = sum(1, 2, _)

  def intoTheWormhole(f: Int => Int)    = throughTheWormhole(f)
  def throughTheWormhole(f: Int => Int) = otherSideOfWormhole(f)

  // supply 10 to whatever function you receive:
  def otherSideOfWormhole(f: Int => Int) = f(10)

  @main def test =
    Equals(intoTheWormhole(addTo3), 13)
}

// pp. 294-295
package t3 {
  def wrap(prefix: String, html: String, suffix: String) =
    prefix + html + suffix

  val wrapWithDiv = wrap("<div>", _, "</div>")

  @main def test =
    val a = wrapWithDiv("<p>Hello, world</p>")
    val b = wrapWithDiv("""<img src="/images/foo.png" />""")
    val c = wrap("<pre>", "val x = 1", "</pre>")
    println(a)
    println(b)
    println(c)
}
