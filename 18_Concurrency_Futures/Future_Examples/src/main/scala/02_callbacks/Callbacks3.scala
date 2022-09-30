package r02_callbacks

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Failure, Random, Success }
import Thread.sleep

@main def callbacks3 =

  val f: Future[Int] = Future {
    val sleepTime = Random.nextInt(500)
    sleep(sleepTime)
    if sleepTime > 250 then throw new Exception("Ka-boom")
    42
  }

  f.foreach(println(_))

  sleep(1_000)
