package r06_method_returns_function

import com.alvinalexander.simpletest.SimpleTest.*


// p. 296
package t1 {
    // single line syntax
    // def saySomething(prefix: String) = (str: String) => s"$prefix $str"

    // multiline syntax, which might be easier to read
    // def saySomething(prefix: String) = (str: String) =>
    //     s"$prefix $str"

    // with the return type
    def saySomething(prefix: String): (String => String) = (str: String) => 
        s"$prefix $str"

    @main def test =
        val sayHello = saySomething("Hello")
        Equals(sayHello("Al"), "Hello Al")
}


// pp. 297-298
package t2 {
    // def greeting(language: String) = (name: String) =>
    //     language match
    //         case "english" => s"Hello, $name"
    //         case "spanish" => s"Buenos dias, $name"
    
    // [a] declare the 'String => String' return type
    def greeting(language: String): (String => String) = (name: String) =>
        // [b] create the function values here, then return them from the
        // match expression
        val englishFunc = () => s"Hello, $name"
        val spanishFunc = () => s"Buenos dias, $name"
        language match
            case "english" => println("returning the english function")
                              englishFunc()
            case "spanish" => println("returning the spanish function")
                              spanishFunc()

    @main def test =
        val hello = greeting("english")
        val buenosDias = greeting("spanish")
        
        Equals(hello("Al"), "Hello, Al")
        Equals(buenosDias("Lorenzo"), "Buenos dias, Lorenzo")

}


// p. 298
package t3 {
    def greeting(language: String): (String => String) = (name: String) =>

        // [1] define the methods
        def englishMethod = s"Hello, $name"
        def spanishMethod = s"Buenos dias, $name"

        // [2] return the correct method via a match expression
        language match
            case "english" => println("returning the english method")
                              englishMethod
            case "spanish" => println("returning the spanish method")
                              spanishMethod
}





