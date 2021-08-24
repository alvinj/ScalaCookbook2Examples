package r08_varargs

import annotation.varargs

// pp. 662-663
object VarargsPrinter:
    @varargs def printAll(args: String*): Unit = args.foreach(println)


// p. 663
@main def jVarargsTest = 
    JVarargs.jPrintAll()
    JVarargs.jPrintAll("foo")
    JVarargs.jPrintAll("foo", "bar")


