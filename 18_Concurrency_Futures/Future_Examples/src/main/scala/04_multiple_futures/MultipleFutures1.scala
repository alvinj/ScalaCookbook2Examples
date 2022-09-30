package r04_multi_futures1

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Failure, Success }
import Thread.sleep

@main def multipleFutures1 =

  // (a) create the futures
  val f1 = Future { sleep(800); 1 }
  val f2 = Future { sleep(200); 2 }
  val f3 = Future { sleep(400); 3 }

  // (b) run them simultaneously in a for-comprehension
  val result = for
    r1 <- f1
    r2 <- f2
    r3 <- f3
  yield (r1 + r2 + r3)

  // (c) process the result
  result.onComplete {
    case Success(x) => println(s"result = $x")
    case Failure(e) => e.printStackTrace
  }

  // important for a little parallel demo: keep the jvm alive
  sleep(3000)
