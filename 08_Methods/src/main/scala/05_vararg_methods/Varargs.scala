package r05_varargs

// p. 246
package t1 {

  def printAll(strings: String*) =
    strings.foreach(println)

  @main def varargs =
    // these all work
    printAll()
    printAll("a")
    printAll("a", "b")
    printAll("a", "b", "c")

    // splat operator
    val fruits = List("apple", "banana", "cherry")
    printAll(fruits: _*)
}
