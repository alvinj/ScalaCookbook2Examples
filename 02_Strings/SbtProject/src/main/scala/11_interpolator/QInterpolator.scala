package r11_interp_q

import com.alvinalexander.simpletest.SimpleTest.*

// this demonstrates a first step in the process of creating `Q`.
// in this example Q is not an interpolator, but a Q object with 
// an apply method (factory method, which works like a constructor).
package q_step1 {
    object Q:
        def apply(s: String): Seq[String] = 
            s.split("\n")
             .toSeq
             .map(_.trim)
             .filter(_ != "")

    @main def qTest = 
        val list = Q("""
            http://angel.co/mile-high-organics
            http://angel.co/kindara
            http://angel.co/precog
            http://angel.co/pivotdesk
        """)
        list.foreach(line => println(s"LINE: $line"))
}


// this approach works as an interpolator in Scala 2.
package q_scala2 {
    implicit class QHelper(val sc : StringContext):
        def Q(args : Any*): Seq[String] =
            val strings = sc.parts.iterator
            val expressions = args.iterator
            var buf = new StringBuffer(strings.next)
            while strings.hasNext do
                buf.append(expressions.next)
                buf.append(strings.next)

            buf.toString.split("\n")
               .map(_.trim)
               .filter(_ != "")
               .toList
        end Q

    @main def testQ =
        var result = Q"""
            apples
            bananas
            cherries
        """
        val expected = List("apples", "bananas", "cherries")
        Equals(expected, result, "Scala 2 'Q' test")
}


// this approach works as an interpolator in Scala 3.
// it also shows simple strings as well as variables used
// inside strings.
package q_scala3 {
    extension(sc: StringContext)
        def Q(args : Any*): Seq[String] =
            val strings = sc.parts.iterator
            val expressions = args.iterator
            var buf = new StringBuffer(strings.next)
            while strings.hasNext do
                buf.append(expressions.next)
                buf.append(strings.next)
            buf.toString.split("\n")
               .map(_.trim)
               .filter(_ != "")
               .toList
        end Q
    end extension

    @main def testQ =

        // [1] a test without variable substitution
        var result = Q"""
            apples
            bananas
            cherries
        """
        val expected = List("apples", "bananas", "cherries")
        Equals(expected, result, "Q test WITHOUT variable substitution")

        // [2] a test with variable substitution
        val as = "apples"
        val bs = "bananas"
        val cs = "cherries"
        result = Q"""
            $as
            $bs
            $cs
            dates
        """
        val expected2 = List("apples", "bananas", "cherries", "dates")
        Equals(expected2, result, "Q test WITH variable substitution")


}
