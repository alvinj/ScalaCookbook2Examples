package r06_java_interfaces_in_scala

// p. 660
class Dog extends Animal, Wagging, Running:
  def speak = println("Woof")
  def wag   = println("Tail is wagging")

@main def test =
  val d = Dog()
  d.speak
  d.wag
  d.run // from the java interface

  // Discussion
  println(Mathy.add(1, 1))
