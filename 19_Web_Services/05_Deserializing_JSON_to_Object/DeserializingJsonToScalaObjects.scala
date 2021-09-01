package r05_json_to_object

// pp. 576-577

// this code is mentioned on p. 576, but it’s not a preferred approach
// for real-world code.
    // // conversion without validation
    // implicit val movieReads: Reads[Movie] = (
    //     (JsPath \ "title").read[String] and
    //     (JsPath \ "year").read[Int] and
    //     (JsPath \ "rating").read[Double]
    // )(Movie.apply _)
    //
    // *can* do this
    // val json: JsValue = Json.parse(jsonString)
    // val movie = Json.fromJson(json)
    // // JsResult[Movie] = JsSuccess(Movie(The Princess Bride,1987,8.5),)


// more of a real-world approach.
// conversion with validation.
// minLength, min, and max are validation methods that come with
// the Reads object.
package t1 {
    import play.api.libs.json._
    import play.api.libs.functional.syntax._
    import play.api.libs.json.Reads._

    case class Movie(title: String, year: Int, rating: Double)

    object MovieReads {
        implicit val movieReads: Reads[Movie] = (
            (JsPath \ "title").read[String](minLength[String](2)) and
            (JsPath \ "year").read[Int](min(1920).keepAnd(max(2020))) and
            (JsPath \ "rating").read[Double](min(0d).keepAnd(max(10d)))
        )(Movie.apply _)
    }

    object R05a_JsonStringToScalaObject extends App {
        
        import MovieReads._

        // [1] given a string like this that contains JSON ...
        val jsonString = """{"title":"The Princess Bride","year":1987,"rating":8.5}"""

        // [2] parse that string into a JsValue ...
        val json: JsValue = Json.parse(jsonString)

        // [3] then that will be a JsSuccess or JsError, as shown in the next
        // two steps
        val jsResult = json.validate[Movie]
        // jsResult has this value:
        // JsResult[Movie] = JsSuccess(Movie(The Princess Bride,1987,8.5),)

        jsResult match {
            case JsSuccess(movie,_) => println(movie)
            case e: JsError         => println(s"error: $e")
        }
    }

}



// p. 580
package t2 {
    
    import play.api.libs.json._
    import play.api.libs.json.Reads._
    import play.api.libs.functional.syntax._

    case class Movie(title: String, year: Int, rating: Double)

    object MovieReads {
        implicit val movieReads: Reads[Movie] = (
            (JsPath \ "title").read[String](minLength[String](2)) and
            (JsPath \ "year").read[Int](min(1920).keepAnd(max(2020))) and
            (JsPath \ "rating").read[Double](min(0d).keepAnd(max(10d)))
        )(Movie.apply _)
    }

    object R05b_JsonArrayToScalaObject extends App {
        
        import MovieReads._

        // [1] given an array of movies as a JSON string ...
        val jsonString = """[
            {"title":"The Princess Bride","year":1987,"rating":8.5},
            {"title":"The Matrix","year":1999,"rating":8.8},
            {"title":"Firefly","year":2002,"rating":9.2}
        ]"""

        // [2] parse that string into a JsValue ...
        val json: JsValue = Json.parse(jsonString)

        // [3] then that will be a JsSuccess or JsError, as shown in the next
        // two steps
        val jsResult = json.validate[Seq[Movie]]
        jsResult.get.foreach(println)

    }


}


// other code shown on pp. 578-579 is shown below.

/*
// When working with JSON in a controller method you’ll work with the 
// `request` object

// one option
def yourMethod = Action { request: Request[AnyContent] =>
    val json: Option[JsValue] = request.body.asJson
    // more the json here ...
}

// another option ("body parser")
def yourMethod = Action(parse.json) { request: Request[JsValue] =>
    // work with 'request' as JSON here
    val name = request.body \ "username").as[String]
}


// The pattern shown in the solution is known as the combinator pattern:
(JsPath \ "title").read[String] and
(JsPath \ "year").read[Int] and
(JsPath \ "rating").read[Double]

// For nested objects, use a search path like this:
val city = JsPath \ "address" \ "city"

// For sequences of objects, access sequence elements like this:
val friend0 = (JsPath \ "friends")(0)

*/


