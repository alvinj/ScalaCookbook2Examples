package r06_processing

import com.alvinalexander.simpletest.SimpleTest.*

package examples {
    @main def processingChars =
    
        // the filter/map example in the Solution
        val result = "hello, world"
                    .filter(_ != 'l')
                    .map(_.toUpper)
        True(result == "HEO, WORD")

        // the `for` expression in the Discussion
        val result2 = for
            c <- "hello, world"
            if c != 'l'
        yield
            c.toUpper
        True(result2 == "HEO, WORD")
}


package adler {
    def adler32sum(s: String): Int =
        val MOD_ADLER = 65521
        var a = 1
        var b = 0

        // loop through each byte, updating `a` and `b`
        s.getBytes.foreach{ byte =>
            a = (byte + a) % MOD_ADLER
            b = (b + a) % MOD_ADLER
        }

        // this is the return value.
        // note that Int is 32 bits, which this requires.
        b * 65536 + a     // or (b << 16) + a

    @main def adler32Checksum =
        val sum = adler32sum("Wikipedia")
        println(f"checksum (int) = ${sum}%d")
        println(f"checksum (hex) = ${sum.toHexString}%s")
}


