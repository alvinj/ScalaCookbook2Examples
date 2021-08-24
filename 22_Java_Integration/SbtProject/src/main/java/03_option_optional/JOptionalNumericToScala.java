package r03_option_optional;

import java.util.Optional;
import java.util.OptionalInt;


// p. 655
public class JOptionalNumericToScala {
    public static Optional<Integer> oInt = Optional.of(1);
    public static Optional<Integer> oEmptyInt = Optional.empty();
    public static OptionalInt optionalInt = OptionalInt.of(1);
}

