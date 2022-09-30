package r09_parameterized_traits

// pp. 198
package t1 {
  // a generic trait type parameter
  trait Stringify[A]:
    def string(a: A): String
}

// pp. 199
package t2 {
  // a type member
  trait Stringify:
    type A
    def string(a: A): String
}

// pp. 199, a complete type parameter example
package t3 {
  trait Stringify[A]:
    def string(a: A): String = s"value: ${a.toString}"

  @main def typeParameter =
    object StringifyInt extends Stringify[Int]
    println(StringifyInt.string(100))
}

// pp. 199, a complete type member example
package t4 {
  trait Stringify:
    type A
    def string(a: A): String

  object StringifyInt extends Stringify:
    type A = Int
    def string(i: Int): String = s"value: ${i.toString}"

  @main def typeMember =
    println(StringifyInt.string(42))
}

// pp. 199-200
package t5_discussion {
  trait Pair[A, B]:
    def getKey: A
    def getValue: B

  sealed trait Dog
  class LittleDog extends Dog
  class BigDog    extends Dog

  trait Barker:
    type D <: Dog // type member
    def bark(d: D): Unit

  object LittleBarker extends Barker:
    type D = LittleDog
    def bark(d: D) = println("wuf")

  object BigBarker extends Barker:
    type D = BigDog
    def bark(d: D) = println("WOOF!")

  @main def example =
    val terrier = LittleDog()
    val husky   = BigDog()

    LittleBarker.bark(terrier)
    BigBarker.bark(husky)

    // won’t work, compiler error
    // BigBarker.bark(terrier)

}
