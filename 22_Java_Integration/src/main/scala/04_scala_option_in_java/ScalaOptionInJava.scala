package r04_scala_option_in_java

import scala.jdk.OptionConverters.*


// pp. 656-657
// create java.util.Optional[String] values
object Scala:
    // convert a Some to Optional
    val scalaStringSome = Option("foo").toJava

    // convert a None to Optional
    val scalaStringNone = Option.empty[String].toJava

    // p. 657
    val intOptional1 = Option(1).toJava            // Optional[Int], or 
                                                   // Optional[Object]
    val optionalInt = Option(1).toJavaPrimitive    // OptionalInt
    val optionalInt2 = optionalInt.toJavaGeneric   // Optional[Int]

    // p. 658
    val optionString = Option("foo")

