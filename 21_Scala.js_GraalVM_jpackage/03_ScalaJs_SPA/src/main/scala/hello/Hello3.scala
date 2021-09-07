package hello

import org.scalajs.dom
import dom.document
import scalatags.JsDom.all._

@main def Hello3 =

    // create an html button with scalatags
    val btn = button(
        "Click me",
        onclick := { () =>
            dom.window.alert("Hello, world")
        }
    )

    // this is intentional overkill to demonstrate scalatags.
    // the most important thing is that the button is added here.
    val content =
        div(id := "foo",
            div(id := "bar",
                h2("Hello"),
                btn
            )
        )

    val root = dom.document.getElementById("root")
    root.innerHTML = ""
    root.appendChild(content.render)

