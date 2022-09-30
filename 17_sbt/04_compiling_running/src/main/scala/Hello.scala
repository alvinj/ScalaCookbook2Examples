package foo.bar.baz

package t1 {
  // p. 499
  @main def main = println("Hello, world")
}

// pp. 500-501
// run from your operating system command line with these commands:
// sbt "run Charles Carmichael"
// sbt -v -J-Xmx2048m -Duser.timezone=America/Denver "run Charles Carmichael"
package t2 {
  @main def hello(args: String*) =
    print(s"Hello, ")
    for a <- args do print(s"$a ")
}
