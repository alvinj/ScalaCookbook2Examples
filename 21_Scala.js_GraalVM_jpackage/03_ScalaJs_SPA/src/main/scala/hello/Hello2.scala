package hello

import org.scalajs.dom
import org.querki.jquery._

@main def Hello2 = 
    // handle the login button click
    $("#hello-button").click{() =>
        dom.window.alert("Hello, world")
    }

