package r05_compare_floats

import com.alvinalexander.simpletest.SimpleTest.*

package t1 {
    import scala.annotation.targetName

    @targetName("approxEqual")
    def ~=(x: Double, y: Double, tolerance: Double): Boolean = 
        if (x - y).abs < tolerance then true else false

    @main def testApproxEqual = 
        val a = 0.3         // 0.3
        val b = 0.1 + 0.2   // 0.30000000000000004
        True(~=(a, b, 0.0001), "a~=b")
        True(~=(b, a, 0.0001), "b~=a")
        True(~=(a, b, 0.0) == false, "0 tolerance")
}

package t2 {
    extension (x: Double)
        def ~=(y: Double): Boolean = (x - y).abs < 0.5

    @main def testApproxEqualExtensionMethod = 
        val a = 1.5
        val b = 1.99
        True(a ~= b, "a ~= b")
        True(b ~= a, "b ~= a")

        val c = 2.00
        False(a ~= c, "a ~= c")
        False(c ~= a, "c ~= a")
}

package t3 {
    extension (x: Double)
        def ~=(y: Double): Boolean =
            // allow a +/- 10% variance        
            val xHigh = if x > 0 then x*1.1 else x*0.9
            val xLow = if x > 0 then x*0.9 else x*1.1
            if y >= xLow && y <= xHigh then true else false

    @main def testApproxEqualWithNegatives = 
        // positive numbers
        val x = 1.5   // 1.35 to 1.65
        val xLow = 1.35
        val xHigh = 1.65
        True(x ~= 1.5)
        True(x ~= 1.49)
        True(x ~= 1.51)
        True(x ~= 1.35)
        True(x ~= 1.65)
        False(x ~= 1.34)
        False(x ~= 1.66)
        // negative numbers
        val y = -1.0   // -1.10 to -0.90
        True(y ~= -1.00)
        True(y ~= -1.10)
        True(y ~= -0.90)
        False(y ~= -1.11)
        False(y ~= -0.89)

}


package t4 {
    extension (x: Double)
        def ~=(y: Double, tolerance: Double): Boolean =
            if (x - y).abs < tolerance then true else false

    @main def testToleranceParameter = 
        val x = 1.5   // 1.35 to 1.65
        val xLow = 1.35
        val xHigh = 1.65

        val y = 1.0
        True(y ~= (1.1, .2))
        True(y ~= (0.9, .2))

        True(y ~= (1.2, .2))
        True(y ~= (0.8, .2))

        False(y ~= (1.21, .2))
        False(y ~= (0.79, .2))
}



