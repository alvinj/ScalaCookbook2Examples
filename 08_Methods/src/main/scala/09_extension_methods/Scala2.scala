package r09_extension_methods

import com.alvinalexander.simpletest.SimpleTest.*

// pp. 253-254
package t1 {

  object StringExtensions:
    extension (s: String)
      def hello: String     = s"Hello, ${s.capitalize}"
      def increment: String = s.map(c => (c + 1).toChar)
      def hideAll: String   = s.replaceAll(".", "*")

  import StringExtensions.*

  @main def stringExtensionsTest =
    Equals("joe".hello, "Hello, Joe")
    Equals("hal".increment, "ibm")
    Equals("password".hideAll, "********")

}

// p. 254
package t2 {
  extension (s: String) def makeInt(radix: Int): Int = Integer.parseInt(s, radix)

  @main def makeIntTest =
    Equals("1".makeInt(2), 1)
    Equals("10".makeInt(2), 2)
    Equals("100".makeInt(2), 4)

    Equals("1".makeInt(8), 1)
    Equals("10".makeInt(8), 8)
    Equals("100".makeInt(8), 64)
}
