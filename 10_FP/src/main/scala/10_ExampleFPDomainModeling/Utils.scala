package r10_pizzastore
package utils


// pp. 310-311
object ListUtils:

    /**
     * Drops the first matching element in a list, as in this example:
     * {{{
     * val xs = List(1,2,3,1)
     * dropFirstMatch(xs, 1) == List(2,3,1)
     * }}}
     */
    def dropFirstMatch[A](xs: Seq[A], value: A): Seq[A] =
        val idx = xs.indexOf(value)
        for
            (x, i) <- xs.zipWithIndex
            if i != idx
        yield
            x

end ListUtils


package ListUtilsTest:
    import com.alvinalexander.simpletest.SimpleTest.*

    import ListUtils.dropFirstMatch

    val ints = List(1,2,3,1)
    val listOf1 = List(1)
    val listOf1s = List(1,1,1)

    @main def testDropFirstMatch = 
        Equals(List(2,3,1),   dropFirstMatch(ints,  1))
        Equals(List(1,2,3,1), dropFirstMatch(ints, 99))
        Equals(List(1,2,3,1), dropFirstMatch(ints,  0))
        Equals(List(1,2,3,1), dropFirstMatch(ints, -1))
        Equals(List(1,3,1),   dropFirstMatch(ints,  2))
        Equals(List(1,2,1),   dropFirstMatch(ints,  3))

        Equals(List(1),   dropFirstMatch(listOf1,  0))
        Equals(List(1),   dropFirstMatch(listOf1,  -1))
        Equals(Nil,       dropFirstMatch(listOf1,   1))

        Equals(List(1,1,1), dropFirstMatch(listOf1s,  0))
        Equals(List(1,1),   dropFirstMatch(listOf1s,  1))




