package r11_interp

def debug(s: String) = println(s"DEBUG: $s")

import com.alvinalexander.simpletest.SimpleTest.*

package t1 {
    // this package contains the short version of the `caps` method,
    // which is shown in the Scala Cookbook
    extension(sc: StringContext)
        def caps(args: Any*): String =

            // create variables for the iterators. note that for an
            // input string "a b c", `strings` will be "a b c" at this
            // point.
            val strings: Iterator[String] = sc.parts.iterator
            val expressions: Iterator[Any] = args.iterator

            // populate a StringBuilder from the values in the iterators
            val sb = StringBuilder(strings.next.trim)
            while strings.hasNext do
                sb.append(expressions.next.toString)
                sb.append(strings.next)

            // convert the StringBuilder back to a String,
            // then apply an algorithm to capitalize each word in 
            // the string
            sb.toString
                .split(" ")
                .map(_.trim)
                .map(_.capitalize)
                .mkString(" ")
        end caps
    end extension

    @main def interpCapsShort =

        // no variable substitution
        var a = caps"john c doe"
        Equals("John C Doe", a)

        // variable substitution
        val first = "john"
        val last = "doe"
        a = caps"$first $last"
        Equals("John Doe", a)

        // left/right trimming
        a = caps" john c doe "
        Equals("John C Doe", a, "strings are trimmed left and right")

        Equals("Doe C Doe", a, "intentional error")
        Todo("test blank strings")
        True("John C Doe" == a)
        False("Doe C Doe" == a)

        // the current algorithm leaves multiple blank spaces in
        // the middle of the string. this may be good or bad, 
        // depending on what you want:
        a = caps" $first   $last "
        Equals("John   Doe", a, "multiple spaces are retained")

}


package t2 {
    // i used the code in this package to debug the 
    // contents of the two iterators (sc.parts.iterator
    // and args.iterator)
    import scala.collection.mutable.ArrayBuffer
    extension(sc: StringContext)
        def yo(args: Any*): String =
            val strings: Iterator[String] = sc.parts.iterator
            val expressions: Iterator[Any] = args.iterator

            var count = 0
            while strings.hasNext do
                println(s"strings|$count: |${strings.next}|")

            count = 0
            while expressions.hasNext do
                println(s"exprs  |$count: |${expressions.next}|")

            return "fred"
        end yo

    @main def interpTest1 =
        val b = "b"
        val d = "d"
        val rez = yo"a $b c $d"

   /* RESULT:
   strings|0: |a |
   strings|0: | c |
   strings|0: ||
   exprs  |0: |b|
   exprs  |0: |d|
   */

}


package t3 {
    // this package contains the complete `caps` method,
    // including some debug code, which may be useful
    import scala.collection.mutable.ArrayBuffer
    extension(sc: StringContext)
        def caps(args: Any*): String =
            val strings: Iterator[String] = sc.parts.iterator
            val expressions: Iterator[Any] = args.iterator

            // this may be "john doe", " john doe ", or it may be 
            // empty when `s"$first $last"` is used:
            // val string1 = strings.next.trim
            // debug(s"string1 = $string1")
            val sb = StringBuilder(strings.next.trim)
            // debug(s"sb(initial): $sb")
            while strings.hasNext do
                // TODO a better way to iterate over both?
                // debug("strings.hasNext == true")
                val stringsNext = strings.next
                val exprsNext = expressions.next.toString
                // debug(s"stringsNext: $stringsNext")
                // debug(s"exprsNext: $exprsNext")
                sb.append(exprsNext)
                sb.append(stringsNext)

            debug(s"StringBuilder: $sb")
            sb.toString
                .split(" ")
                .map(_.trim)
                .map(_.capitalize)
                .mkString(" ")
        end caps
    end extension

    @main def capsShort =

        // no variable substitution
        var a = caps"john c doe"
        Equals("John C Doe", a)

        // variable substitution
        val first = "john"
        val last = "doe"
        a = caps"$first $last"
        Equals("John Doe", a)

        // left/right trimming
        a = caps" john c doe "
        Equals("John C Doe", a, "strings are trimmed left and right")

        Equals("Doe C Doe", a, "intentional error")
        Todo("test blank strings")
        True("John C Doe" == a)
        False("Doe C Doe" == a)

        // the current algorithm leaves multiple blank spaces in
        // the middle of the string. this may be good or bad, 
        // depending on what you want:
        a = caps" $first   $last "
        Equals("John   Doe", a, "multiple spaces are retained")

}



