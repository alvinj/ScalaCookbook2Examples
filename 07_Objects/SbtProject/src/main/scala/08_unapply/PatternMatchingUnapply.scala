package r08_pattern_matching_unapply

// pp. 230-231
package t1 {
    class Person(val name: String, val age: Int) 
    object Person:
        def unapply(p: Person): String = s"${p.name}, ${p.age}"
    
    @main def unapply1 =
        val p = Person("Lori", 33)
        val personAsAString = Person.unapply(p) // "Lori, 33"
        println(personAsAString)
}


// p. 231
package t2 {
    class Person(val name: String, val age: Int)
    object Person:
        def unapply(p: Person): Option[(String, Int)] = Some(p.name, p.age)

    @main def unapply2 =
        val p = Person("Lori", 33)
        val deconstructedPerson: String = p match
            case Person(n, a) => s"name: $n, age: $a"
            case null => "null!"
        println(deconstructedPerson)

}







