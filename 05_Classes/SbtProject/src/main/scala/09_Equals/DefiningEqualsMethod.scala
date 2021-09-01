package r09_equals_method

import com.alvinalexander.simpletest.SimpleTest.*

// pp. 156-157
class Person (var name: String, var age: Int):

    // Step 1 - proper signature for `canEqual`
    // Step 2 - compare `a` to the current class
    // (isInstanceOf returns 'true' or 'false')
    def canEqual(a: Any) = a.isInstanceOf[Person]

    // Step 3 - proper signature for `equals`
    // Steps 4 thru 7 - implement a `match` expression
    override def equals(that: Any): Boolean =
        that match
            case that: Person =>
                that.canEqual(this) &&
                this.name == that.name &&
                this.age == that.age
            case _ => 
                false

    // Step 8 - implement a corresponding hashCode method
    override def hashCode: Int =
        val prime = 31
        var result = 1
        result = prime * result + age
        result = prime * result + (if name == null then 0 else name.hashCode)
        result

end Person


// pp. 157-158
package t1 {

    // the tests shown here replace the ScalaTest tests
    // shown in the Cookbook
    @main def personEqualsTests =
        // these first two instances should be equal
        val nimoy   = Person("Leonard Nimoy", 82)
        val nimoy2  = Person("Leonard Nimoy", 82)
        val nimoy83 = Person("Leonard Nimoy", 83)
        val shatner = Person("William Shatner", 82)

        // [1] a basic test to start with
        True(nimoy != null, "nimoy   != null")

        // [2]  these reflexive and symmetric tests should all be true
        // [2a] reflexive
        True(nimoy == nimoy, "nimoy   == nimoy")
        // [2b] symmetric
        True(nimoy == nimoy2, "nimoy   == nimoy2")
        True(nimoy2 == nimoy, "nimoy2  == nimoy")

        // [3] these should not be equal
        True(nimoy != nimoy83, "nimoy   != nimoy83")
        True(nimoy != shatner, "nimoy   != shatner")
        True(shatner != nimoy, "shatner != nimoy")
    
}


// p. 159
class Employee(name: String, age: Int, var role: String)
extends Person(name, age):
    override def canEqual(a: Any) = a.isInstanceOf[Employee]

    override def equals(that: Any): Boolean =
        that match
            case that: Employee =>
                that.canEqual(this) &&
                this.role == that.role &&
                super.equals(that)
            case _ => 
                false

    override def hashCode: Int =
        val prime = 31
        var result = 1
        result = prime * result + (if role == null then 0 else role.hashCode)
        result + super.hashCode

end Employee


// p. 160
package t2 {

    @main def employeeEqualsTests =
        // these first two instance should be equal
        val eNimoy1 = Employee("Leonard Nimoy", 82, "Actor")
        val eNimoy2 = Employee("Leonard Nimoy", 82, "Actor")
        val pNimoy = Person("Leonard Nimoy", 82)
        val eShatner = Employee("William Shatner", 82, "Actor")

        // equality tests (reflexive and symmetric)
        True(eNimoy1 == eNimoy1, "eNimoy1 == eNimoy1")
        True(eNimoy1 == eNimoy2, "eNimoy1 == eNimoy2")
        True(eNimoy2 == eNimoy1, "eNimoy2 == eNimoy1")

        // non-equality tests
        True(eNimoy1  != pNimoy,   "eNimoy1  != pNimoy")
        True(pNimoy   != eNimoy1,  "pNimoy   != eNimoy1")
        True(eNimoy1  != eShatner, "eNimoy1  != eShatner")
        True(eShatner != eNimoy1,  "eShatner != eNimoy1")

}


// pp. 160-161
package t3 {
    @main def testEmployeeWithSet =
        val eNimoy = Employee("Leonard Nimoy", 81, "Actor")

        val set = scala.collection.mutable.Set[Employee]()
        set += eNimoy
        True(set.contains(eNimoy), "This should be true")

        eNimoy.age = 82
        False(set.contains(eNimoy), "This will *probably* be false")
        
}











