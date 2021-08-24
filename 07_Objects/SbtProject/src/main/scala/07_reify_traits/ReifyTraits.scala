package r07_reify_traits

// pp. 227-228
package t1 {
    trait Animal

    // in a world where all dogs and cats have names
    case class Dog(name: String) extends Animal
    case class Cat(name: String) extends Animal

    // assumes that all animal have legs
    trait AnimalServices:
        def walk(a: Animal) = println(s"$a is walking")
        def run(a: Animal) = println(s"$a is running")
        def stop(a: Animal) = println(s"$a is stopped")

    @main def reifyTraits1 =
        object AnimalServices extends AnimalServices
        val zeus = Dog("Zeus")
        AnimalServices.walk(zeus)
        AnimalServices.run(zeus)
        AnimalServices.stop(zeus)

}


// pp. 228-229
package t2 {

    // [1] the base traits
    trait Animal
    trait AnimalWithLegs
    trait AnimalWithTail
    case class Dog(name: String) extends Animal, AnimalWithLegs, AnimalWithTail
    
    // [2] the trait services
    trait TailServices:
        def wagTail(a: AnimalWithTail) = println(s"$a is wagging tail")
        def stopTail(a: AnimalWithTail) = println(s"$a tail is stopped")
    trait AnimalWithLegsServices:
        def walk(a: AnimalWithLegs) = println(s"$a is walking") 
        def run(a: AnimalWithLegs) = println(s"$a is running") 
        def stop(a: AnimalWithLegs) = println(s"$a is stopped")
    trait DogServices:
        def bark(d: Dog) = println(s"$d says ‘woof’")

    @main def reifyTraits2 =
        object DogServices extends DogServices, AnimalWithLegsServices, TailServices
        import DogServices.*
        val rocky = Dog("Rocky")
        walk(rocky)
        wagTail(rocky)
        bark(rocky)

}


// pp. 229-230
package t3 {

    // [1] the base traits
    trait Animal
    trait AnimalWithLegs
    trait AnimalWithTail
    case class Dog(name: String) extends Animal, AnimalWithLegs, AnimalWithTail
    
    // [2] the trait services
    trait TailServices[AnimalWithTail]:
        def wagTail(a: AnimalWithTail) = println(s"$a is wagging tail")
    trait AnimalWithLegsServices[AnimalWithLegs]:
        def walk(a: AnimalWithLegs) = println(s"$a is walking")
    trait DogServices[Dog]:
        def bark(d: Dog) = println(s"$d says ‘woof’")

    @main def reifyTraits3 =
        object DogServices extends 
            DogServices[Dog], 
            AnimalWithLegsServices[Dog], 
            TailServices[Dog]        
        import DogServices.*

        val xena = Dog("Xena")
        walk(xena)      // Dog(Xena) is walking
        wagTail(xena)   // Dog(Xena) is wagging tail
        bark(xena)      // Dog(Xena) says ‘woof’
}




