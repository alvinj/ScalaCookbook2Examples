package r7_3

import sttp.client3.*

// pp. 587-588
@main def post =
  val backend = HttpURLConnectionBackend()
  val response = basicRequest
    .body("Hello, world!")
    .post(uri"https://httpbin.org/post?hello=world")
    .send(backend)
  println(response)
