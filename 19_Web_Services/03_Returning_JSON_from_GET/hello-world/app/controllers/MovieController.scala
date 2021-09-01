package controllers

// pp. 568-569

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models.Movie

@Singleton
class MovieController @Inject()(val controllerComponents: ControllerComponents)
extends BaseController {

    /**
     * Let Play convert the `List[String]` to JSON for you.
     */
    def getMovies = Action {
        // these three steps are shown explicitly so you
        // can see the types:
        val goodMovies: Seq[String] = Movie.goodMovies()
        val json: JsValue = Json.toJson(goodMovies)
        Ok(json)
    }

}

