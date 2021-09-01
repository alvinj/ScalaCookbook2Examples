package r14_case_classes

import com.alvinalexander.simpletest.SimpleTest.*

package t1 {
    // (p. 171) name and relation are 'val' by default
    case class Person(name: String, relation: String)

    // (p. 172)
    case class Company(var name: String)

    @main def tests =

        val emily = Person("Emily", "niece")   // Person(Emily,niece)
        Equals(emily.name, "Emily")
        Equals(emily.toString, "Person(Emily,niece)")

        val c = Company("Mat-Su Valley Programming")
        Equals(c.name, "Mat-Su Valley Programming")
    
        val hannah = Person("Hannah", "niece")
        False(emily == hannah)
    
        c.name = "Valley Programming"
        Equals(c.name, "Valley Programming")
}


// p. 173
package t2 {
    
    case class Person(firstName: String, lastName: String)
    
    @main def tests =
        val fred = Person("Fred", "Flintstone")
        val wilma = fred.copy(firstName = "Wilma")
        Equals(wilma.toString, "Person(Wilma,Flintstone)")
    
}


// p. 175
package t3 {
    // an example of a 'case object'
    sealed trait Message
    case class Speak(text: String) extends Message
    case object StopSpeaking extends Message
}








