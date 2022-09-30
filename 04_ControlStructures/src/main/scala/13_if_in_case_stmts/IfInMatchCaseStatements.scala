package r13_if_in_match_case

package t1 {
  case class Stock(symbol: String, price: BigDecimal)
  @main def ifInMatchCase =
    def buy(a: Any)  = println("buy")
    def sell(a: Any) = println("sell")

    val stock = Stock("AAPL", BigDecimal(132.50))
    stock match
      case s if s.symbol == "AAPL" && s.price < 140 => buy(s)
      case s if s.symbol == "AAPL" && s.price > 160 => sell(s)
      case _                                        => // do nothing
}

package t2 {
  // works with a case class
  case class Person(aName: String)
  def speak(p: Person) = p match
    case Person(name) if name == "Fred"    => println("Yubba dubba doo")
    case Person(name) if name == "Bam Bam" => println("Bam bam!")
    case _                                 => println("Watch the Flintstones!")
  @main def extractFields =
    speak(Person("Joe"))
    speak(Person("Fred"))
    speak(Person("Bam Bam"))
}

package t3 {
  // works with a plain class with 'unapply'.
  // note that apply returns an `Option[String]`. this is because
  // `Person` has one parameter. If it had multiple parameters
  // you should return an `Option[Tuple]`.
  class Person(val aName: String)
  object Person:
    def unapply(p: Person): Option[String] = Some(p.aName)
  def speak(p: Person) = p match
    case Person(name) if name == "Fred"    => println("Yubba dubba doo")
    case Person(name) if name == "Bam Bam" => println("Bam bam!")
    case _                                 => println("Watch the Flintstones!")
  @main def extractFields =
    speak(Person("Joe"))
    speak(Person("Fred"))
    speak(Person("Bam Bam"))
}

package t4 {
  class Person(var name: String, var age: Int)
  object Person:
    def unapply(p: Person): (String, Int) = (p.name, p.age)

  @main def testUnapplyWithTuples =
    val p = Person("Lori", 33)
    val deconstructedPerson = p match
      case Person(n, a) => s"name: $n, age: $a"
      case null         => "null!"
    println(deconstructedPerson)
}
