package r03_option_optional

// scala
import java.util.Optional
import com.alvinalexander.simpletest.SimpleTest.*


// p. 654
package t1 {
    @main def test =
        val optionalString = JavaClass.oString         // Optional[foo]
        val eOptionalString = JavaClass.oEmptyString   // Optional.empty

        Equals(optionalString, Optional.of("foo"))
        Equals(eOptionalString, Optional.empty)
}


// p. 654
package t2 {
    import scala.jdk.OptionConverters.*

    @main def test =
        val optionalString = JavaClass.oString         // Optional[foo]
        Equals(optionalString, Optional.of("foo"))
    
        val optionString = optionalString.toScala      // Some(foo)
        Equals(optionString, Some("foo"))

        val eOptionalString = JavaClass.oEmptyString   // Optional.empty
        Equals(eOptionalString, Optional.empty)

        val eOptionString = eOptionalString.toScala    // None
        Equals(eOptionString, None)
}


// p. 655
package t3 {

    import java.util.Optional
    
    // note: this import was not required in the earliest versions of Scala 3.0
    import scala.jdk.OptionConverters.RichOptional
    import scala.jdk.OptionConverters.RichOptionalInt

    // Optional[Int]
    val optionalInt = JOptionalNumericToScala.oInt           // Optional[1]
    val optionInt = optionalInt.toScala                      // Some(1)

    // Optional[Int] (empty)
    val eOptionalInt = JOptionalNumericToScala.oEmptyInt     // Optional.empty
    val eOptionInt = eOptionalInt.toScala                    // None

    // OptionalInt
    val optionalInt2 = JOptionalNumericToScala.optionalInt   // OptionalInt[1]
    val sOptionalInt2 = optionalInt2.toScala                 // Some(1)
    
}


// p. 656
package t4 {
    @main def test =
        val oInt1 = JOptionalNumericToScala2.oInt1   // Some(1)
        val oInt2 = JOptionalNumericToScala2.oInt2   // Some(2)
        
        Equals(oInt1, Some(1))
        Equals(oInt2, Some(2))
        
}








