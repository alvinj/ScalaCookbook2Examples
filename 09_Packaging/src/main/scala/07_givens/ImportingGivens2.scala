package r07_import_givens_2

package t2 {
    package co.kbhr.givens {
        object Adder:
            trait Adder[T]:
                def add(a: T, b: T): T
            given Adder[Int] with
                def add(a: Int, b: Int): Int = a + b
            given Adder[String] with
                def add(a: String, b: String): String = "" + (a.toInt + b.toInt)
    }

    @main def givenImports2 =
        // this is one 'import' approach.
        // when put on separate lines, the order of the imports is important.
        // the second import statement imports the givens by their type.
        // import co.kbhr.givens.Adder.*
        // import co.kbhr.givens.Adder.{given Adder[Int], given Adder[String]}

        // this approach also works
        import co.kbhr.givens.Adder.*
        import co.kbhr.givens.Adder.{given Adder[?]}

        def genericAdder[A](x: A, y: A)(using adder: Adder[A]): A = adder.add(x, y)
        println(genericAdder(1, 1))       // 2
        println(genericAdder("2", "2"))   // 4
}
