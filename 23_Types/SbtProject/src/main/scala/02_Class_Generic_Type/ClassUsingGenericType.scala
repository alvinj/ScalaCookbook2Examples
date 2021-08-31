package r02_class_using_generic_type

import com.alvinalexander.simpletest.SimpleTest.*

class LinkedList[A]:
    private class Node[A] (elem: A):
        var next: Node[A] = _
        override def toString = elem.toString

    private var head: Node[A] = _

    def add(elem: A): Unit =
        val n = new Node(elem)
        n.next = head
        head = n

    private def printNodes(n: Node[A]): Unit =
        if n != null then
            println(n)
            printNodes(n.next)

    def printAll() = printNodes(head)
end LinkedList


// pp. 678-679
package t1 {
    
    @main def test =
        val ints = LinkedList[Int]()
        ints.add(1)
        ints.add(2)
        ints.printAll()
        
        val strings = LinkedList[String]()
        strings.add("Emily")
        strings.add("Hannah")
        strings.printAll()
        
        val doubles = LinkedList[Double]()
        doubles.add(1.1)
        doubles.add(2.2)
        doubles.printAll()
}


// pp. 679-680
package t2 {
    // i added a toString method here make the printed output
    // meaningful
    trait Person:
        def name: String
        override def toString = name
    class Employee(val name: String) extends Person
    class StoreEmployee(name: String) extends Employee(name)

    def printEmps(es: LinkedList[Employee]) = es.printAll()
    
    @main def test =
        val emps = LinkedList[Employee]()
        emps.add(Employee("Al"))
        printEmps(emps)
}








