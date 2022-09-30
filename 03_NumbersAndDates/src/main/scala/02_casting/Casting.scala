package r02_casting

import com.alvinalexander.simpletest.SimpleTest.*

package t1 {
  @main def castingByte =
    val b: Byte = 1
    True(b.toShort == 1)
    True(b.toInt == 1)
    True(b.toLong == 1)
    True(b.toFloat == 1.0f)
    True(b.toDouble == 1.0)
}

package t2 {
  @main def castingDouble =
    val d = 100.0 // Double = 100.0
    True(d.toFloat == 100.0)
    True(d.toLong == 100L)
    True(d.toInt == 100)
    True(d.toShort == 100)
    True(d.toByte == 100)
}

package t3 {
  @main def asInstanceOfTests =
    val b: Byte = 1 // Byte = 1
    True(b.asInstanceOf[Short] == 1)
    True(b.asInstanceOf[Int] == 1)
    True(b.asInstanceOf[Long] == 1)
    True(b.asInstanceOf[Float] == 1)
    True(b.asInstanceOf[Double] == 1)
}

package t4 {
  @main def asInstanceOfToBigDecimal =
    True(BigDecimal(100) == 100)     // Int
    True(BigDecimal(100L) == 100)    // Long
    True(BigDecimal(100.0) == 100)   // Double
    True(BigDecimal(100f) == 100)    // Float
    True(BigDecimal("100") == 100)   // String
    True(BigDecimal(BigInt(1)) == 1) // BigInt
}
