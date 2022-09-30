package r7_6

import sttp.client3.*
import scala.concurrent.duration._

// p. 588
@main def timeout =
  // specify backend options, like a connection timeout
  val backend = HttpURLConnectionBackend(
    options = SttpBackendOptions.connectionTimeout(5.seconds)
  )

  // can also set a read timeout
  val request = basicRequest
    .get(uri"https://httpbin.org/get")
    .readTimeout(5.seconds)

  val response = request.send(backend)
  println(response)
