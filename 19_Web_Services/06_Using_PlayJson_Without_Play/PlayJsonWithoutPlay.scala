package r06_play_json_without_play


// pp. 581-582
package t1 {
    import play.api.libs.json._

    case class Movie(title: String, year: Int, rating: Double)

    object JsonWithoutPlay_WritesExample extends App {

        implicit val movieWrites = new Writes[Movie] {
            def writes(m: Movie) = Json.obj(
                "title" -> m.title,
                "year" -> m.year,
                "rating" -> m.rating
            )
        }

        val pb = Movie("The Princess Bride", 1987, 8.5)    

        println(Json.toJson(pb))
        // that line prints this:
        // {"title":"The Princess Bride","year":1987,"rating":8.5}

    }
    
}


// pp. 582-583
package t2 {
    import play.api.libs.json._
    import play.api.libs.functional.syntax._
    import play.api.libs.json.Reads._
    import sttp.client3._

    // a case class to model the data received from the REST url
    case class ToDo(
        userId: Int,
        id: Int,
        title: String,
        completed: Boolean
    )

    object JsonWithoutPlay_ReadsExample extends App {

        // the Reads implementation that matches the data.
        // the first three fields are also validated.
        implicit val todoReads: Reads[ToDo] = (
            (JsPath \ "userId").read[Int](min(0)) and
            (JsPath \ "id").read[Int](min(0)) and
            (JsPath \ "title").read[String](minLength[String](2)) and
            (JsPath \ "completed").read[Boolean]
        )(ToDo.apply _)

        // make the GET request with sttp
        val response = basicRequest
            .get(uri"https://jsonplaceholder.typicode.com/todos/1")
            .send(HttpURLConnectionBackend())

        // get the JSON from the response, then convert the JSON string
        // to a Scala `ToDo` instance
        response.body match {
            case Left(e)  => println(s"Response error: $e")
            case Right(jsonString) => 
                val json: JsValue = Json.parse(jsonString)
                val jsResult = json.validate[ToDo]
                jsResult match {
                    case JsSuccess(todo, _) => println(todo)
                    case e: JsError         => println(s"JsError: $e")
                }
                // results in this output:
                // ToDo(1,1,delectus aut autem,false)
        }
    }
    
}


