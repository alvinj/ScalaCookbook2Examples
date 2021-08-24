package r00_intro


package t1 {
    trait Pet:
        def speak() = println("Yo")   // concrete implementation 
        def comeToMaster(): Unit      // // abstract method

    trait HasLegs:
        def run() = println("I’m running!")
    
    class Dog extends Pet, HasLegs:
        def comeToMaster() = println("I'm coming!")

    @main def traitsIntro = 
        val d = Dog()
        d.speak()          // yo
        d.comeToMaster()   // I’m coming!
        d.run()            // I’m running
}


package t2 {
    trait First:
        println("First is constructed")
    trait Second:
        println("Second is constructed")
    trait Third:
        println("Third is constructed")

    class MyClass extends First, Second, Third:
        println("MyClass is constructed")

    @main def traitConstructionOrder = 
        val c = MyClass()
        // First is constructed
        // Second is constructed
        // Third is constructed
        // MyClass is constructed
}





