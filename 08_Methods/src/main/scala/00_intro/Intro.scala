package r00_intro

// All of these examples are from the introduction
// to Chapter 8 (Methods).


package t1 {
    def printHello(name: String) = println(s"Hello, $name")
    def printString(s: String) = println(s)

    @main def hiMom =
        printHello("mom")
        printString("Look mom, no classes or objects required!")
}


package t2 {
    class Foo:
        final def foo = "foo" // FINAL

    // this class won’t compile, so it’s commented-out
    // class FooFoo extends Foo:
    //     override def foo = "foo foo" // ERROR, won’t compile
}


package t3 {

    // these two methods show the return type
    def isBetween(a: Int, x: Int, y: Int): Boolean = 
        a >= x && a <= y

    def max(a: Int, b: Int): Int = 
        if a > b then a else b

    @main def tests =
        println(isBetween(1,0,2))
        println(isBetween(1,0,1))
        println(!isBetween(2,0,1))
        println(max(1,2) == 2)
        println(max(3,2) == 3)
        println(max(2,2) == 2)
}


package t4 {
    def sum(xs: List[Int]): Int = xs match
        case Nil => 0
        case x :: tail => x + sum(tail)

    @main def sumTest =
        println(sum(List(1)) == 1)
        println(sum(List(1,2)) == 3)
        println(sum(List(1,2,3)) == 6)
}


package t5 {

    def allThoseBetween3and10(xs: List[Int]): List[Int] =
        for
            x <- xs
            if x >= 3
            if x <= 10
        yield
            x

    @main def test5Between = 
        println(allThoseBetween3and10(List(1,3,7,11)))   // List(3, 7)

}



