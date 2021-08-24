package r03_binary_files

import java.io.FileInputStream
import java.io.BufferedInputStream
import java.io.IOException
import scala.util.{Try, Success, Failure}
import java.nio.charset.StandardCharsets

// This is an example I used for testing. On my computer it takes
// about 1.6 seconds to read an Apache access log file with 650K 
// lines with BufferedReader. By comparison it takes about 181 seconds
// to read the same file with FileReader. (My access log file is
// not included here.)
package read_test {
    def timer[A](blockOfCode: => A) = {
        val startTime = System.nanoTime
        val result = blockOfCode
        val stopTime = System.nanoTime
        val delta = stopTime - startTime
        (result, delta/1000000d)
    }

    @main def readWithTimer =
        val filename = "access.log.2"
        val (result, time) = timer {
            val bis = BufferedInputStream(FileInputStream(filename))
            Iterator.continually(bis.read())
                .takeWhile(_ != -1)
                .foreach(b => b)  // do whatever you want with each byte
                // .foreach(b => println(b.toChar))
            bis.close()
        }
        println(s"time = $time")
}



