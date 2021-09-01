package r02_primary_constructor

class Employee(var firstName: String, var lastName: String):
    // a statement
    println("the constructor begins ...")

    // some class fields (variable assignments)
    var age = 0
    private var salary = 0d

    // a method call
    printEmployeeInfo()

    // methods defined in the class
    override def toString = s"$firstName $lastName is $age years old"
    def printEmployeeInfo() = println(this) //uses toString

    // any statement or field prior to the end of the class
    // definition is part of the class constructor
    println("the constructor ends")

// optional 'end' statement
end Employee


@main def test =
    val e = Employee("Kim", "Carnes")
    
    // because i made firstName and lastName 'var' fields,
    // their values can be mutated
    e.firstName = "Xena"
    e.lastName = "Princess Warrior"
    println(e.firstName)   // Xena 
    println(e.lastName)    // Princess Warrior

    e.age = 30
    println(e.age)   // 30







