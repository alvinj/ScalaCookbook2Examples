package r13_uninitialized_var_fields

// p. 170
package t1 {
  case class Person(var username: String, var password: String):
    var age                      = 0
    var firstName                = ""
    var lastName                 = ""
    var address: Option[Address] = None

  case class Address(city: String, state: String, zip: String)

  @main def test =
    val p = Person("alvinalexander", "secret")
    p.address = Some(Address("Talkeetna", "AK", "99676"))

    p.address.foreach { a =>
      println(s"${a.city}, ${a.state}, ${a.zip}")
    }
}
