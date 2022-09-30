package r12_enum_in_match

package t1 {
  enum Animal:
    case Dog(name: String)
    case Cat(name: String)
    case Woodpecker

  import Animal.*

  def getAnimalInfo(a: Animal): String = a match
    case Dog(moniker) => s"Got a Dog, name = $moniker"
    case _: Cat       => "Got a Cat (ignoring the name)"
    case Woodpecker   => "That was a Woodpecker"

  @main def enumInMatch =
    println(getAnimalInfo(Dog("Fido")))
    println(getAnimalInfo(Cat("Morris")))
    println(getAnimalInfo(Woodpecker))
}

package t2 {
  sealed trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal
  case object Woodpecker       extends Animal

  def getAnimalInfo(a: Animal): String = a match
    case Dog(moniker) => s"Got a Dog, name = $moniker"
    case _: Cat       => "Got a Cat (ignoring the name)"
    case Woodpecker   => "That was a Woodpecker"

  @main def sealedTraitInMatch =
    println(getAnimalInfo(Dog("Fido")))
    println(getAnimalInfo(Cat("Morris")))
    println(getAnimalInfo(Woodpecker))
}
