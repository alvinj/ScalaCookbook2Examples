package r7_2

import sttp.client3.*

// pp. 586-587
@main def basicGetHeader =
  val backend = HttpURLConnectionBackend()
  // note: all data is sent and received as json
  val response = basicRequest
    .header("Accept", "application/vnd.github.v3+json")
    .get(uri"https://api.github.com")
    .send(backend)
  println(response.body)
