package r06_duck_typing

// pp. 689+

// this import statement is required. see:
// https://dotty.epfl.ch/docs/reference/changed-features/structural-types-spec.html
import reflect.Selectable.reflectiveSelectable

def callSpeak[A <: { def speak(): Unit }](obj: A): Unit =
  obj.speak()

class Dog:
  def speak() = println("woof")

class Klingon:
  def speak() = println("Qapla!")

@main def test =
  callSpeak(Dog())
  callSpeak(Klingon())
