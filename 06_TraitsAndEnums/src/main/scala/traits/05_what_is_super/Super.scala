package r05_what_is_super

import com.alvinalexander.simpletest.SimpleTest.*

// pp. 189-190
package t1 {
    trait Hello:
        def greet = "hello"
    trait Hi:
        def greet = "hi"
    // resolve the conflict by overriding 'greet' in the class
    class Greeter extends Hello, Hi:
        override def greet = "I greet thee!"

    @main def overrideGreet =
        // the 'greet' method override works as expected
        val g = Greeter()
        True(g.greet == "I greet thee!")
}


// p. 191
package t2 {
    trait Parent:
        def speak = "make your bed"
    trait Granddad:
        def speak = "get off my lawn"

    // resolve the conflict by calling 'super.speak'
    class Speaker extends Parent, Granddad:
        override def speak = super.speak

    @main def callSuperSpeak = 
        println(Speaker().speak)   // "get off my lawn"
}


// p. 191
package t3 {
    trait Hello:
        def greet = "hello"
    trait Hi:
        def greet = "hi"
    trait Yo:
        def greet = "yo"

    class Greeter extends Hello, Hi, Yo:
        override def greet = super.greet 
        def greetHello = super[Hello].greet 
        def greetHi = super[Hi].greet 
        def greetYo = super[Yo].greet
    end Greeter

    @main def controlSuperYouCall = 
        val g = Greeter()
        Equals(g.greet,      "yo")
        Equals(g.greetHello, "hello")
        Equals(g.greetHi,    "hi")
        Equals(g.greetYo,    "yo")
}


package t4 {
    trait A:
        def f(a: Int, b: Int): Int = 1    // (Int, Int)
    trait B:
        def f(a: Int, b: Long): Int = 2   // (Int, Long)
    // this code compiles because 'A.f' and 'B.f' have different
    // parameter lists
    class C extends A, B
}




