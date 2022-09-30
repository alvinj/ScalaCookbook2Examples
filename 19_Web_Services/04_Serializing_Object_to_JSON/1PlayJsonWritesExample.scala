package test

// pp. 572-573

import play.api.libs.json._

case class Movie(title: String, year: Int, rating: Double)

object MovieWrites {
  implicit val movieWrites = new Writes[Movie] {
    def writes(m: Movie) = Json.obj(
      "title"  -> m.title,
      "year"   -> m.year,
      "rating" -> m.rating
    )
  }
}

object R04a_JsonWritesExample extends App {

  import MovieWrites._

  val pb = Movie("The Princess Bride", 1987, 8.5)

  println(Json.toJson(pb))
  // that line prints this output:
  // {"title":"The Princess Bride","year":1987,"rating":8.5}

}

// p. 573
object R04b_JsonWritesSequence extends App {

  import MovieWrites._

  val goodMovies = List(
    Movie("The Princess Bride", 1987, 8.5),
    Movie("The Matrix", 1999, 8.8),
    Movie("Firefly", 2002, 9.2)
  )

  val json = Json.toJson(goodMovies)
  println(json)
  // that line prints goodMovies as JSON

}
