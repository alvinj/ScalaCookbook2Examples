package r01_read_files

import scala.io.BufferedSource
import scala.util.{Try, Success, Failure}
import com.alvinalexander.simpletest.SimpleTest.*

// For more information, see my blog post, [Five good ways (and two bad ways) 
// to read large text files with
// Scala](https://alvinalexander.com/scala/different-ways-read-large-text-file-with-scala-performance/)


// This example is shown at the beginning of Recipe 16.1.
package t1 {
    @main def example1 = 
        import scala.io.Source
        for (line <- Source.fromFile("/etc/passwd").getLines)
            // do whatever you need to do with each line in the file
            println(line)
}


// This is the next example.
package t2 {
    @main def example2 = 
        import scala.io.Source
        val linesAsList = Source.fromFile("/etc/passwd").getLines.toList
        val linesAsString = Source.fromFile("/etc/passwd").getLines.mkString
        True(linesAsList.size > 10)
        True(linesAsString.length > 100)
}


// "Properly closing the file and handling exceptions"
package t3 {
    import scala.util.Using
    import scala.util.{Try, Success, Failure}

    def readFileAsSeq1(filename: String): Try[Seq[String]] =
        Using(io.Source.fromFile(filename)) { bufferedSource =>
            bufferedSource.getLines.toList
        }

    def readFileAsSeq2(filename: String): Try[Seq[String]] =
        Using(io.Source.fromFile(filename)) { _.getLines.toList }

    @main def scalaUtilUsing = 
        val a = readFileAsSeq1("/etc/passwd")
        val b = readFileAsSeq2("/etc/passwd")
        True(a.isSuccess)
        True(b.isSuccess)
        True(a.get.size > 10)
        True(b.get.size > 10)
        val c = readFileAsSeq2("/etc/passwd-FOO")
        True(c.isFailure)
}


// This is the last example just before the Discussion.
// It demonstrates how to use a complete scala.util.Using
// approach where you can work with each line.
package t4 {
    import scala.util.Using
    import scala.util.{Try, Success, Failure}

    def readFileAsSeq(filename: String): Try[Seq[String]] =
        Using(io.Source.fromFile(filename)) { bufferedSource =>
            val ucLines = for
                line <- bufferedSource.getLines
                // 'line' is a String. can work with each Char here,
                // if desired
            yield
                // work with each 'line' as a String here
                line.toUpperCase
            ucLines.toSeq
        }

    @main def scalaUtilUsingFull = 
        val a = readFileAsSeq("/etc/passwd")
        a.get.foreach(println)

}


