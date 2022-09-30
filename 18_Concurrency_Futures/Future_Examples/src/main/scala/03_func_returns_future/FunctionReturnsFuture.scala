package r03_futures

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Random}
import Thread.sleep

@main def futuresFunction =

    // a function that returns a Future
    def longRunningComputation(i: Int): Future[Int] = Future {
        sleep(100)
        i + 1
    }

    // this does not block
    longRunningComputation(11).onComplete {
        case Success(result) => println(s"result = $result")
        case Failure(e) => e.printStackTrace
    }

    // keep the jvm from shutting down
    sleep(1_000)

