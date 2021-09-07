package hello

import org.scalajs.dom
import org.querki.jquery.*

@main def hello2 = 
    // handle the login button click
    $("#hello-button").click{() =>
        dom.window.alert("Hello, world")
    }

