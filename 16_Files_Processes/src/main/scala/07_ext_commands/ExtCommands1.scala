package r07_ext_commands

import sys.process.*
import scala.language.implicitConversions
import com.alvinalexander.simpletest.SimpleTest.*

// The first example in the Solution.
package t1 {
  @main def exitStatusTests =
    // run this process (which prints its output)
    // and return the exit status.
    val exitStatus1 = "ls -al".!
    True(exitStatus1 == 0)

    // returns '1' because the file doesn’t exist.
    // notice that when you run this, the error message is
    // printed to stderr.
    val exitStatus2 = "ls -l noSuchFile.txt".!
    True(exitStatus2 == 1)
}

// The second example in the Solution.
// This one prints the 'ls' command output to stdout.
package t2 {
  @main def postfixOpsTest =
    import scala.language.postfixOps
    "ls -al" !
}

// Shows how to wrap a process with Try.
// In this example, the 'ls' error message is still
// printed to stderr.
package t3 {
  import scala.util.Try
  @main def tryWithProcess =
    val result = Try(
      Seq(
        "/bin/sh",
        "-c",
        "ls -l foo.bar"
      ).!!
    )
    println(s"result: $result")

    // Another Seq example:
    // val exitStatus = Seq("ls", "-a", "-l", "/tmp").!
}

// This is the first example in the Discussion
package t4 {
  @main def runTest =
    val process = "ls -al".run
    println(s"process = $process")
    // val process = "sleep 20".run
}

// Other examples shown in the Discussion:
val exitStatus1 = Seq("ls", "-al").!
val exitStatus2 = Seq("ls", "-a", "-l").!
val exitStatus3 = Seq("ls", "-a", "-l", "/tmp").!

val status1 = sys.process.Process("ls -al").!
val status2 = sys.process.Process(Seq("ls", "-al")).!
