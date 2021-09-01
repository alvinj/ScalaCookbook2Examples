package r06_default_parameter_values

import com.alvinalexander.simpletest.SimpleTest.*

// p. 148
package t1 {
    class Socket(val timeout: Int = 10_000)
    
    @main def socketTest =
        val s1 = Socket()
        Equals(s1.timeout, 10_000)
        
        val s2 = Socket(5_000)
        Equals(s2.timeout, 5_000)
}


// p. 149
package t2 {
    class Socket(val timeout: Int = 1_000, val linger: Int = 2_000):
        override def toString = s"timeout: $timeout, linger: $linger"

    @main def multipleParameters =         
        println(Socket())               // timeout: 1000, linger: 2000
        println(Socket(3_000))          // timeout: 3000, linger: 2000
        println(Socket(3_000, 4_000))   // timeout: 3000, linger: 4000
        
        println(Socket(timeout=3_000, linger=4_000))   // timeout: 3000, linger: 4000
        println(Socket(linger=4_000, timeout=3_000))   // timeout: 3000, linger: 4000
        println(Socket(timeout=3_000))                 // timeout: 3000, linger: 2000
        println(Socket(linger=4_000))                  // timeout: 1000, linger: 4000
        
}






