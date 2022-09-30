package r7_5

import sttp.client3.*

// p. 588
@main def cookies =
  val backend = HttpURLConnectionBackend()
  val response = basicRequest
    .get(uri"https://httpbin.org/cookies")
    .cookie("first_name", "sam")
    .cookie("last_name", "weiss")
    .send(backend)
  println(response)
