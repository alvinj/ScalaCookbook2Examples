package r01_futures

import scala.concurrent.{ Await, ExecutionContext, Future }
import scala.concurrent.duration.*
import scala.util.Random

/** These are some examples that show different ways to import an ExecutionContext. They are from Hermann Hueck, a
 *  reviewer of the 2nd Edition of the Scala Cookbook.
 */
@main def futures1b(): Unit =

  println("\u2500" * 80)

  // given ec: ExecutionContext = ExecutionContext.global // define a given with name ec
  // given ExecutionContext = ExecutionContext.global     // or, we just need the type, the name is irrelevant

  // or we provide the ExecutionContext with an import
  // import ExecutionContext.Implicits.global   // import the name global
  // import ExecutionContext.Implicits.given    // imports all givens in Implicits
  import ExecutionContext.Implicits.given ExecutionContext // imports the given with type ExecutionContext

  // [1] create a Future that runs in a separate thread and
  // returns “eventually”
  val f = Future {
    // this can be any long-running algorithm
    Thread.sleep(Random.nextInt(500))
    1 + 1
  }

  // [2] this is blocking, i.e., pausing the current thread to wait for a
  // result from another thread
  val result = Await.result(f, 1.second)
  println(result)
  Thread.sleep(1000)

  println("\u2500" * 80)
