package r04_scala_option_in_java;

// for the 1st example
import java.util.Optional;

// for the 2nd example
import java.util.OptionalInt;

// for the 3rd example
import scala.jdk.javaapi.OptionConverters;

public class ScalaOptionInJava {
    public static void main(String[] args) {

        // p. 656
        Optional<String> stringSome = Scala.scalaStringSome();  // Optional[foo]
        Optional<String> stringNone = Scala.scalaStringNone();  // Optional.empty

        // p. 657
        Optional intOptional1   = Scala.intOptional1();   // Optional[1]
        OptionalInt optionalInt = Scala.optionalInt();    // OptionalInt[1]
        Optional optionalInt2   = Scala.optionalInt2();   // Optional[1]

        // p. 658
        Optional<String> stringOptional = OptionConverters.toJava(Scala.optionString());
        
    }
}



    