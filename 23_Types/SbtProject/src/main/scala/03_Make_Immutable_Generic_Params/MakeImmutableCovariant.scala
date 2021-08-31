package r03_make_immut_cocariant

import com.alvinalexander.simpletest.SimpleTest.*


// p. 682
trait Animal:
    def speak(): Unit

class Dog(var name: String) extends Animal:
    def speak() = println("Dog says woof")

class SuperDog(name: String) extends Dog(name):
    override def speak() = println("I’m a SuperDog")


// pp. 682-683
package t1 {
    
    def makeDogsSpeak(dogs: Seq[Dog]): Unit = dogs.foreach(_.speak())
    
    @main def test =

        // this works
        val dogs = Seq(Dog("Nansen"), Dog("Joshu"))
        makeDogsSpeak(dogs)
        
        // this works too
        val superDogs = Seq(
            SuperDog("Wonder Dog"),
            SuperDog("Scooby")
        )
        makeDogsSpeak(superDogs)
        
}


// p. 683
package t2 {
    class Container[+A] (val elem: A)
    
    def makeDogsSpeak(dogHouse: Container[Dog]): Unit = dogHouse.elem.speak()

    @main def test =
        val dogHouse = Container(Dog("Xena"))
        makeDogsSpeak(dogHouse)
    
        val superDogHouse = Container(SuperDog("Wonder Dog"))
        makeDogsSpeak(superDogHouse)
}


// p. 684
package t3 {
    // this compiles, as desired
    class Container[+A] (val elem: A):
        // 'A' is correctly used in the “out” position
        def getElemAsTuple: (A) = (elem)
}





