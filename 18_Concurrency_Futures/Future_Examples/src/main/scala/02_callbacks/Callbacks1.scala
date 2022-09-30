package r02_callbacks

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Random}
import Thread.sleep

def getMeaningOfLife() =
    sleep(Random.nextInt(500))
    42

@main def callbacks1_OnComplete =

    println("starting calculation ...")
    val f = Future {
        getMeaningOfLife()
    }

    println("before onComplete")

    // Option 1
    f.onComplete {
        case Success(value) => println(s"Got the callback, meaning = $value")
        case Failure(e) => e.printStackTrace
    }

    // Option 2
    // f.onComplete (_.fold(
    //         _.printStackTrace, 
    //         value => println(s"Got the callback, meaning = $value")
    //     )
    // )

    // do the rest of your work
    println("A ..."); sleep(100)
    println("B ..."); sleep(100)
    println("C ..."); sleep(100)
    println("D ..."); sleep(100)
    println("E ..."); sleep(100)
    println("F ..."); sleep(100)

    sleep(2000)
    
