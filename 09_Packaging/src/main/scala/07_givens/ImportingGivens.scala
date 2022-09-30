package r07_import_givens_1

package co.kbhr.givens {
  object Adder:
    trait Adder[T]:
      def add(a: T, b: T): T
    given intAdder: Adder[Int] with
      def add(a: Int, b: Int): Int = a + b
}

package t1 {
  @main def givenImports =
    import co.kbhr.givens.Adder.*     // import all non-given definitions
    import co.kbhr.givens.Adder.given // import all `given` definitions
    // import co.kbhr.givens.Adder.{given, *}

    def genericAdder[A](x: A, y: A)(using adder: Adder[A]): A = adder.add(x, y)
    println(genericAdder(1, 1))
}
