package r12_named_values_enums

import com.alvinalexander.simpletest.SimpleTest.*

// pp. 210+
enum CrustSize:
  case Small, Medium, Large
enum CrustType:
  case Thin, Thick, Regular
enum Topping:
  case Cheese, Pepperoni, Mushrooms, GreenPeppers, Olives

// an example of how to import enums, and then
// do something with them
package t1 {
  import CrustSize.*
  import CrustType.*
  import Topping.*

  @main def enumTest =
    for e <- CrustSize.values do println(e)
    for e <- CrustType.values do println(e)
    for t <- Topping.values do println(t)
}

// p. 211
package t2 {
  enum HttpResponse(val code: Int):
    case Ok                  extends HttpResponse(200)
    case MovedPermanently    extends HttpResponse(301)
    case InternalServerError extends HttpResponse(500)

  @main def testHttpResponse =
    import HttpResponse.*
    Equals(Ok.code, 200)
    Equals(MovedPermanently.code, 301)
    Equals(InternalServerError.code, 500)

}

// p. 212, compatibility with java
package t3 {
  enum CrustSize extends Enum[CrustSize]:
    case Small, Medium, Large
}
