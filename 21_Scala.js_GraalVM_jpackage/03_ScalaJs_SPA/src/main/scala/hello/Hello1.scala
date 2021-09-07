package hello

// [1] the Solution code:
// @main def hello() = println("Hello, world")

// [2] the Discussion code:
import org.scalajs.dom
import dom.document

@main def hello1() = 
    val parNode = document.createElement("p")
    val textNode = document.createTextNode("Hello, world")
    parNode.appendChild(textNode)
    document.body.appendChild(parNode)
    println("foo")
    System.err.println("bar")
