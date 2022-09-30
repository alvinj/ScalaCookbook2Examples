package test

// pp. 574-575, nested objects

import play.api.libs.json._

/** Model classes
 *  -------------
 */
case class Address(
  street: String,
  city: String,
  state: String,
  postalCode: String
)

case class Person(name: String, address: Address)

/** JSON classes
 *  ------------
 */
object WritesConverters {
  import play.api.libs.json._

  implicit val addressWrites = new Writes[Address] {
    def writes(a: Address) = Json.obj(
      "street"     -> a.street,
      "city"       -> a.city,
      "state"      -> a.state,
      "postalCode" -> a.postalCode
    )
  }

  implicit val personWrites = new Writes[Person] {
    def writes(p: Person) = Json.obj(
      "name"    -> p.name,
      "address" -> p.address
    )
  }
}

object R04c_JsonWrites2AddressPerson extends App {

  import WritesConverters._

  val stubbs = Person(
    "Stubbs",
    Address(
      "123 Main Street",
      "Talkeetna",
      "Alaska",
      "99676"
    )
  )

  val jsValue = Json.toJson(stubbs)
  println(jsValue)
  // the output is:
  // {"name":"Stubbs","address":{"street":"123 Main Street","city":"Talkeetna","state":"Alaska","postalCode":"99676"}}

}
