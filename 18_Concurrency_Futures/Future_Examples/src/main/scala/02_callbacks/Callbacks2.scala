package r02_callbacks

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Failure, Random, Success }
import Thread.sleep

@main def callbacks2 =

  println("Creating the future")
  val f: Future[Int] = Future {
    // sleep for a random time before returning 42
    val sleepTime = Random.nextInt(500)
    sleep(sleepTime)
    println("Leaving the future")
    if sleepTime > 250 then throw new Exception("Ka-boom")
    42
  }

  // handle the result of f with andThen
  println("Before andThen")
  f andThen {
    case Success(x) =>
      val y = x * 2
      println(s"andThen: $y")
    case Failure(t) =>
      println(s"andThen: ${t.getMessage}")
  }

  println("After andThen")
  sleep(1_000)
