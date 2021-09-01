package r7_1

import sttp.client3._

// pp. 584-585
package t1 {
    @main def BasicGet = 
        val backend = HttpURLConnectionBackend()
        val response = basicRequest
                          .get(uri"http://httpbin.org/get")
                          .send(backend)
        println(response)

        /* 
        Other methods you can use:

        response.code                       // sttp.model.StatusCode = 200
        response.is200                      // true
        response.isClientError              // false
        response.statusText                 // "OK"
        response.headers                    // Seq[sttp.model.Header]
        response.header("Content-Length")   // Some("344")
        response.isRedirect                 // false
        */
}


package t2 {
    @main def BasicGet = 
        val backend = HttpURLConnectionBackend()
        val response = basicRequest
                          .get(uri"http://httpbin.org/get")
                          .send(backend)

        // p. 585 example
        response.body match
            case Left(error)   => println(s"LEFT:  $error")
            case Right(result) => println(s"RIGHT: $result")
}








