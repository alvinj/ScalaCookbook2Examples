package r03_option_optional;

import java.util.Optional;
import java.util.OptionalInt;
import scala.jdk.javaapi.OptionConverters;
import scala.Option;


// p. 656 (i added the '2' to the end of this class name)
public class JOptionalNumericToScala2 {
    public static Option<Integer> oInt1 = OptionConverters.toScala(Optional.of(1));
    public static Option<Integer> oInt2 = OptionConverters.toScala(OptionalInt.of(2));
}
    
