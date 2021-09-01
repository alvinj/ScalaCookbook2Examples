package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models._

@Singleton
class HelloController @Inject()(val controllerComponents: ControllerComponents)
extends BaseController {

    def sayHello() = Action {
        // the first example
        // Ok("Hello, world")
        
        // Van Halen example
        Status(5150)("Van Halen status")
    }

    def sayHi(theName: String) = Action {
        Ok(s"Hi, $theName")
    }

}

