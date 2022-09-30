package r01_interfaces

// p. 182
trait HasTail:
  def startTail(): Unit
  def stopTail(): Unit

trait HasLegs:
  def startRunning(speed: Double): Unit
  def runForNSeconds(speed: Double, numSeconds: Int): Unit

class Dog extends HasTail, HasLegs:
  def startTail(): Unit = println("Tail is wagging")
  def stopTail(): Unit  = println("Tail is stopped")
  def startRunning(speed: Double): Unit =
    println(s"Running at $speed miles/hour")
  def runForNSeconds(speed: Double, numSeconds: Int): Unit =
    println(s"Running at $speed miles/hour for $numSeconds seconds")

@main def traitAsInterface =
  val d = Dog()
  d.startTail()
  d.stopTail()
  d.startRunning(5)
  d.runForNSeconds(5, 5)

// p. 183
package traits_extend_traits {
  trait SentientBeing:
    def imAlive_!(): Unit = println("I’m alive!")
  trait Furry
  trait Dog extends SentientBeing, Furry
}
