package r02_callbacks

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Failure, Random, Success }
import Thread.sleep

@main def fallbackTo =

  def getMeaningOfLife() = Future {
    sleep(Random.nextInt(500))
    42
  }

  val meaning = getMeaningOfLife() fallbackTo Future(0)
  meaning.foreach(println)
