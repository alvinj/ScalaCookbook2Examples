package r11_pattern_matching_in_match

import System.out.{ println => p }

case class Person(firstName: String, lastName: String)
case class Dog(name: String)

def test(x: Matchable): String = x match

  // constant patterns
  case 0       => "zero"
  case true    => "true"
  case "hello" => "you said 'hello'"
  case Nil     => "an empty List"

  // sequence patterns
  case List(0, _, _) => "a 3-element list with 0 as the first element"
  case List(1, _*)   => "list, starts with 1, has any number of elements"

  // tuples
  case (a, b)    => s"got $a and $b"
  case (a, b, c) => s"got $a, $b, and $c"

  // constructor patterns
  case Person(first, "Alexander") => s"Alexander, first name = $first"
  case Dog("Suka")                => "found a dog named Suka"

  // typed patterns
  case s: String         => s"got a string: $s"
  case i: Int            => s"got an int: $i"
  case f: Float          => s"got a float: $f"
  case a: Array[Int]     => s"array of int: ${a.mkString(",")}"
  case as: Array[String] => s"string array: ${as.mkString(",")}"
  case d: Dog            => s"dog: ${d.name}"
  case list: List[_]     => s"got a List: $list"
  case m: Map[_, _]      => m.toString

  // the default wildcard pattern
  case _ => "Unknown"

end test

@main def patternMatchingInMatch =

  // trigger the constant patterns
  p(test(0))       // zero
  p(test(true))    // true
  p(test("hello")) // you said 'hello'
  p(test(Nil))     // an empty List

  // trigger the sequence patterns
  p(test(List(0, 1, 2)))   // a 3-element list with 0 as the first element
  p(test(List(1, 2)))      // list, starts with 1, has any number of elements
  p(test(List(1, 2, 3)))   // list, starts with 1, has any number of elements
  p(test(Vector(1, 2, 3))) // vector, starts w/ 1, has any number of elements

  // trigger the tuple patterns
  p(test((1, 2)))    // got 1 and 2
  p(test((1, 2, 3))) // got 1, 2, and 3

  // trigger the constructor patterns
  p(test(Person("Melissa", "Alexander"))) // Alexander, first name = Melissa
  p(test(Dog("Suka")))                    // found a dog named Suka

  // trigger the typed patterns
  p(test("Hello, world"))               // got a string: Hello, world
  p(test(42))                           // got an int: 42
  p(test(42f))                          // got a float: 42.0
  p(test(Array(1, 2, 3)))               // array of int: 1,2,3
  p(test(Array("coffee", "apple pie"))) // string array: coffee,apple pie
  p(test(Dog("Fido")))                  // dog: Fido
  p(test(List("apple", "banana")))      // got a List: List(apple, banana)
  p(test(Map(1 -> "Al", 2 -> "Alexander"))) // Map(1 -> Al, 2 -> Alexander)

  // trigger the wildcard pattern
  p(test("33d")) // you gave me this string: 33d
