package r03_simple_hofs

import com.alvinalexander.simpletest.SimpleTest.*


// pp. 287-288
// these methods and functions are all toplevel definitions
def executeFunction(callback:() => Unit) = 
    callback()

val sayHelloF = () => println("Hello")     // function
def sayHelloM(): Unit = println("Hello")   // method

@main def test =
    executeFunction(sayHelloF)
    executeFunction(sayHelloM)

