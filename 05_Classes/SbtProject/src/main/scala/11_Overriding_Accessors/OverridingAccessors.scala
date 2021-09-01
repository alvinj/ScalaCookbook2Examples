package r11_overriding_accessors


// pp. 165-166
package t1 {
    class Person(private var _name: String):
        // accessor
        def name = _name
        // mutator
        def name_=(aName: String): Unit = 
            _name = aName
    
    @main def test =
        val p = Person("Winston Bishop")   // setter
        p.name = "Winnie the Bish"         // getter
        println(p.name)                    // prints "Winnie the Bish"
}

