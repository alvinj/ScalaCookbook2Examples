package r04_class_generic_elements_mutated

trait Animal:
    def speak(): Unit

class Dog(var name: String) extends Animal:
    def speak() = println("woof")
    override def toString = name

class SuperDog(name: String) extends Dog(name):
    def useSuperPower() = println("Using my superpower!")

val fido = Dog("Fido")
val wonderDog = SuperDog("Wonder Dog")


// p. 685
package t1 {
    
    @main def test =    
        import collection.mutable.ArrayBuffer
        val dogs = ArrayBuffer[Dog]()
        dogs += fido
        dogs += wonderDog    
}


// p. 685
package t2 {
    
    import collection.mutable.ArrayBuffer
    def makeDogsSpeak(dogs: ArrayBuffer[Dog]) =
        dogs.foreach(_.speak())

    @main def test =
        // this works
        val dogs = ArrayBuffer[Dog]()
        dogs += fido
        makeDogsSpeak(dogs)

        val superDogs = ArrayBuffer[SuperDog]()
        superDogs += wonderDog
        // makeDogsSpeak(superDogs)  // ERROR: won't compile
        
}





