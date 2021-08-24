package r01_casting

import com.alvinalexander.simpletest.SimpleTest.*

// p. 218
package t1 {
    @main def castingTest =
        val a = 10
        val b = a.asInstanceOf[Long]
        val c = a.asInstanceOf[Byte]
        
        Equals(b, 10L)

        val tenByte: Byte = 10
        Equals(c, tenByte)
}


// p. 218
package t2 {
    val objects = Array("a", 1)
    val arrayOfObject = objects.asInstanceOf[Array[Object]]
    
    val url = "https://google.com"
    import java.net.{URL, HttpURLConnection}
    val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]
}



