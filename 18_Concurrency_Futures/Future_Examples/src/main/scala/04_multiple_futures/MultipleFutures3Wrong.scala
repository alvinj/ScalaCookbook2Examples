package r04_multi_futures3

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import Thread.sleep

def slowlyDouble(
    x: Int, 
    startTime: Long, 
    delay: Int, 
    name: String
): Future[Int] = Future {
    println(s"entered $name: ${delta(startTime)}")
    sleep(delay)
    println(s"leaving $name: ${delta(startTime)}")
    x * 2
}

// time-related functions that are used in the code
def delta(t: Long) = System.currentTimeMillis - t
def time() = System.currentTimeMillis

@main def multipleFuturesWrong =

    val t0 = System.currentTimeMillis

    // WARNING: THIS IS THE INTENTIONALLY WRONG APPROACH
    println(s"\nentering `for`: ${delta(t0)}")
    val result = for
        r1 <- slowlyDouble(x=1, t0, delay=1500, name="f1")
        r2 <- slowlyDouble(x=2, t0, delay=250, name="f2")
        r3 <- slowlyDouble(x=3, t0, delay=500, name="f3")
    yield (r1 + r2 + r3)

    println("\nBEFORE onComplete")
    result.onComplete {
    case Success(x) => {
        println(s"\nresult = $x (delta = ${delta(t0)})")
        println("note that you don't get the result until the last future completes")
    }
    case Failure(e) => e.printStackTrace
    }
    println("AFTER onComplete\n")

    // important for a little parallel demo: keep the jvm alive
    sleep(3000)



