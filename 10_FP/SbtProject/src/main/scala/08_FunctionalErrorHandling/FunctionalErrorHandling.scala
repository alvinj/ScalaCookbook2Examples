package r08_functional_error_handling

import com.alvinalexander.simpletest.SimpleTest.*

def makeInt(s: String): Option[Int] =
    try
        Some(Integer.parseInt(s))
    catch
        case e: NumberFormatException => None

// pp. 303-304
package t1 {
    
    @main def test = 
        makeInt("1")   // Option[Int] = Some(1)
        makeInt("a")   // Option[Int] = None
    
        Equals(makeInt("1"), Some(1))
        Equals(makeInt("a"), None)

        val aString = "foo"
        makeInt(aString) match
            case Some(i) => println(s"i = $i")
            case None => println("Could not create an Int")    

        val listOfStrings = List("a", "1", "b", "2")
        val optionalListOfInts: Seq[Option[Int]] = 
            for s <- listOfStrings yield makeInt(s)
        Equals(optionalListOfInts, List(None, Some(1), None, Some(2)))
        
        val ints = optionalListOfInts.flatten
        Equals(ints, List(1, 2))
}


package t2_option {
    import scala.util.control.Exception._

    def makeInt(s: String): Option[Int] = allCatch.opt(Integer.parseInt(s))
    
    @main def test =
        Equals(makeInt("1"), Some(1))
        Equals(makeInt("a"), None)
}


package t3_try {
    import scala.util.control.Exception._
    import scala.util.{Try, Success, Failure}

    def makeInt(s: String): Try[Int] = Try(Integer.parseInt(s))

    @main def test =
        Equals(makeInt("1"),           Success(1))
        Equals(makeInt("a").isFailure, true)
}


package t4_either {
    import scala.util.control.Exception._

    def makeInt(s: String): Either[Throwable, Int] =
        allCatch.either(Integer.parseInt(s))

    @main def test =
        Equals(makeInt("1"),        Right(1))
        Equals(makeInt("a").isLeft, true)
}





