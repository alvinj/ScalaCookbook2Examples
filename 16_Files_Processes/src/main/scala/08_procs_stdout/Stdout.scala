package r08_stdout

import sys.process.*
import scala.language.implicitConversions
import com.alvinalexander.simpletest.SimpleTest.*
import scala.language.postfixOps

// This is the first example in the Solution.
package t1 {
  @main def readStdout =
    val result: String = "ls -al".!!
    println(result)
}

// This is the second example in the Solution.
// Note that the example in the book is missing the
// 's' string interpolator in the Failure println string.
package t2 {
  import scala.util.{ Failure, Success, Try }

  @main def readStdoutWithTry =
    val result: Try[String] = Try("ls -al fred".!!)
    result match
      case Success(out) => println(s"OUTPUT:\n$out")
      case Failure(f)   => println(s"Exception happened:\n$f")
}

package t3 {

  // run a command asynchronously and access its STDOUT.
  // note that this 'find' command may run for a very long time.
  val contents: LazyList[String] =
    sys.process.Process("find /Users/al -print").lazyLines

  // get rid of potential exceptions
  val x = "ls no_such_file".lazyLines_!

  // also, suppress the STDERR output
  val y = "ls no_such_file" lazyLines_! ProcessLogger(line => ())

}

// Other examples that are shown in the Discussion.
// `!!` runs synchronously, and returns the output of the
// process/command rather than its exit status.
val result1: String = Process("ls -al").!!
val result2: String = Process(Seq("ls", "-al")).!!
val result3: LazyList[String] =
  Process("find /Users/al -print").lazyLines

// Other examples that may not be shown in the book:
val result4 = "ls -al" !!
val result5 = Process("ls -al").!!
val result6 = Seq("ls -al").!!
val result7 = Seq("ls", "-al").!!
val result8 = Seq("ls", "-a", "-l").!!
val result9 = Seq("ls", "-a", "-l", "/tmp").!!

// An example that shows how to run a Unix 'find' command
// while also passing variables into the Seq:
val dir        = "/Users/Al/tmp"
val searchTerm = "adam"
val results = Seq(
  "find",
  dir,
  "-type",
  "f",
  "-exec",
  "grep",
  "-il",
  searchTerm,
  "{}",
  ";"
).!!
