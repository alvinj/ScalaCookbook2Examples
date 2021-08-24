package r01_futures

// [0] the necessary imports
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import Thread.sleep

@main def futures1a =

    // [1] create a Future that runs in a separate thread and 
    // returns “eventually”
    val f = Future {
        // this can be any long-running algorithm
        sleep(Random.nextInt(500))
        1 + 1
    }

    // [2] this is blocking, i.e., pausing the current thread to wait for a
    // result from another thread 
    val result = Await.result(f, 1.second)
    println(result)

    sleep(1000)

