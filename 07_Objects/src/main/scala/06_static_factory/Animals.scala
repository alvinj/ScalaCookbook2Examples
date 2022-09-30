package r06_static_factory

import com.alvinalexander.simpletest.SimpleTest.*

// p. 226
package animals {
  sealed trait Animal:
    def speak(): Unit

  private class Dog extends Animal:
    override def speak() = println("woof")

  private class Cat extends Animal:
    override def speak() = println("meow")

  object Animal:
    // the factory method
    def apply(s: String): Animal =
      if s == "dog" then Dog() else Cat()
}
