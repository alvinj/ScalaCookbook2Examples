import sys.process.*

def clear = "clear".!
def cmd(cmd: String) = cmd.!!
def ls(dir: String) = println(cmd(s"ls -al $dir"))
def help =
    println("\n=== MY CONFIG ===")
    "cat Repl.scala".!

case class Person(name: String)
val nums = List(1, 2, 3)

