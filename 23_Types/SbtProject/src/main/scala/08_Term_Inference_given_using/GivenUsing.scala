package r08_given_using


// pp. 696-697
trait Adder[T]:
    def add(a: T, b: T): T

package t1 {
    given intAdder: Adder[Int] with
        def add(a: Int, b: Int): Int = a + b

    given stringAdder: Adder[String] with
        def add(a: String, b: String): String = s"${a.toInt + b.toInt}"

    def genericAdder[T](x: T, y: T)(using adder: Adder[T]): T =
        adder.add(x, y)

    @main def test =
        println(genericAdder(1, 1))       // 2
        println(genericAdder("2", "2"))   // 4
}


package t2 {
    given Adder[Int] with
        def add(a: Int, b: Int): Int = a + b

    given Adder[String] with
        def add(a: String, b: String): String = "" + (a.toInt + b.toInt)

    def genericAdder[T](x: T, y: T)(using adder: Adder[T]): T =
        adder.add(x, y)

    @main def test =
        println(genericAdder(1, 1))       // 2
        println(genericAdder("2", "2"))   // 4

}


// pp. 698-699
package t3 {
    trait Math[T]:
        def add(a: T, b: T): T
        def subtract(a: T, b: T): T
        // extension methods: create your own api
        extension (a: T)
            def + (b: T) = add(a, b)
            def - (b: T) = subtract(a, b)

    given intMath: Math[Int] with
        def add(a: Int, b: Int): Int = a + b
        def subtract(a: Int, b: Int): Int = a - b

    given stringMath: Math[String] with
        def add(a: String, b: String): String = "" + (a.toInt + b.toInt)
        def subtract(a: String, b: String): String = "" + (a.toInt - b.toInt)

    // `+` here refers to the extension method
    def genericAdd[T](x: T, y: T)(using Math: Math[T]): T =
        x + y

    // `-` here refers to the extension method
    def genericSubtract[T](x: T, y: T)(using Math: Math[T]): T =
        x - y

    @main def test =
        println("add ints:         " + genericAdd(1, 1))            // 2
        println("subtract ints:    " + genericSubtract(1, 1))       // 0

        println("add strings:      " + genericAdd("2", "2"))        // 4
        println("subtract strings: " + genericSubtract("2", "2"))   // 0
        
}


// pp. 699-700
package t4 {
    enum Context:
        case Food, Life

    import Context.*

    // imagine some large decision-tree that uses the Context
    // to determine the meaning of the word that’s passed in
    def search(s: String)(using ctx: Context): String = ctx match
        case Food =>
            s.toUpperCase match 
                case "DATE" => "like a big raisin"
                case "FOIL" => "wrap food in foil before baking"
                case _      => "something else"
        case Life =>
            s.toUpperCase match 
                case "DATE" => "like going out to dinner"
                case "FOIL" => "argh, foiled again!"
                case _      => "something else"

    @main def test =
        given foodContext: Context = Food
        
        // implicitly pulls in the context
        val date1 = search("date")
        println(date1)
        
        // explicitly specify the context
        val date2 = search("date")(using Food)   // "looks like a big raisin"
        val date3 = search("date")(using Life)   // "like going out to dinner"
        println(date2)
        println(date3)

}


// p. 700
package t5 {
    object Adder:
        trait Adder[T]:
            def add(a: T, b: T): T
        given intAdder: Adder[Int] with
            def add(a: Int, b: Int): Int = a + b

    @main def GivenImports = 
    
        // [1a] do this ...
        import Adder.*       // import all non-given definitions
        import Adder.given   // import the `given` definition
        
        // [1b] ... or do this
        // import Adder.{given, *}

        def genericAdder[A](x: A, y: A)(using adder: Adder[A]): A = adder.add(x, y)
        println(genericAdder(1, 1)) 
}


// pp. 700-701
package t6 {
    object Adder:
        trait Adder[T]:
            def add(a: T, b: T): T
        given Adder[Int] with
            def add(a: Int, b: Int): Int = a + b
        given Adder[String] with
            def add(a: String, b: String): String = 
                s"${a.toInt + b.toInt}"

    @main def GivenImports = 
        // when put on separate lines, the order of the imports is important
        import Adder.*
        
        // [1a] do this
        // import Adder.{given Adder[Int], given Adder[String]}
        
        // [1b] or this
        // import Adder.{given Adder[?]}
        
        // [1c] or this
        import Adder.{given Adder[_]}

        def genericAdder[A](x: A, y: A)(using adder: Adder[A]): A = adder.add(x, y)
        println(genericAdder(1, 1))       // 2
        println(genericAdder("2", "2"))   // 4
}








