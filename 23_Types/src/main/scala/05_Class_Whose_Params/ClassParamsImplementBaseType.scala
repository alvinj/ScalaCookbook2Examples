package r05_class_params_impl_base_type

sealed trait CrewMember
class Officer  extends CrewMember
class RedShirt extends CrewMember
trait Captain
trait FirstOfficer
trait ShipsDoctor
trait StarfleetTrained

// p. 687
package t1 {

  // this first line says that 'A' must be a subtype of 'CrewMember'
  class Crew[A <: CrewMember]:
    import scala.collection.mutable.ArrayBuffer
    private val list     = ArrayBuffer[A]()
    def add(a: A): Unit  = list += a
    def printAll(): Unit = list.foreach(println)

  @main def test =
    val kirk  = new Officer with Captain
    val spock = new Officer with FirstOfficer
    val bones = new Officer with ShipsDoctor

    val officers = Crew[Officer]() // only Officer(s) are allowed
    officers.add(kirk)
    officers.add(spock)
    officers.add(bones)

    val redShirt = RedShirt()
    // this next line won’t compile (Found: (redShirt), Required: (Officer))
    // officers.add(redShirt)

    // p. 688
    class StarTrekFan
    // this also won’t compile
    // val officers = Crew[StarTrekFan]()
    // error message:
    // Type argument StarTrekFan does not conform to upper bound CrewMember

    // p. 688
    // this code does compile
    val redshirts = Crew[RedShirt]()
    redshirts.add(redShirt)
}

// pp. 688-689
package t2 {

  class Crew[A <: CrewMember & StarfleetTrained]:
    import scala.collection.mutable.ArrayBuffer
    private val list     = ArrayBuffer[A]()
    def add(a: A): Unit  = list += a
    def printAll(): Unit = list.foreach(println)

  @main def test =
    val kirk  = new Officer with Captain with StarfleetTrained
    val spock = new Officer with FirstOfficer with StarfleetTrained
    val bones = new Officer with ShipsDoctor with StarfleetTrained

    val officers = Crew[Officer & StarfleetTrained]()
    officers.add(kirk)
    officers.add(spock)
    officers.add(bones)

}
