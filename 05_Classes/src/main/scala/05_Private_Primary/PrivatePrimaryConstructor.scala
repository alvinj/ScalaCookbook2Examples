package r05_private_primary_constructor

// pp. 146-148
package t1 {
  // a private one-arg primary constructor
  class Person private (var name: String)

  @main def privatePrimary =
    // this will not compile, as expected/desired
    // val p = Person("Mercedes")
    println("test")
}

// p. 147
package t2 {
  // a private constructor that takes no parameters
  class Brain private:
    override def toString = "This is the brain."

  object Brain:
    val brain       = Brain()
    def getInstance = brain

  @main def singletonTest =
    // this won’t compile because the constructor is private:
    // val brain = Brain()

    // this works:
    val brain = Brain.getInstance
    println(brain) // "This is the brain."
}
