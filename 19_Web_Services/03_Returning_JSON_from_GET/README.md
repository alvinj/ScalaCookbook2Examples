This is the code that’s shown on pp. 571-572:

sbt
console
import play.api.libs.json._

JsString("hi")               // JsString = "hi"
JsNumber(100)                // JsNumber = 100
JsNumber(1.23)               // JsNumber = 1.23
JsNumber(BigDecimal(1.23))   // JsNumber = 1.23
JsBoolean(true)              // JsBoolean = true

val x = Json.toJson(4)       // JsValue = 4
val x = Json.toJson(false)   // JsValue = false

// Sequences
Json.toJson(Seq("A", "B", "C"))   // JsValue = ["A","B","C"]
JsArray(Array(Json.toJson(1)))    // JsArray = [1]
JsArray(Seq(Json.toJson("Hi")))   // JsArray = ["Hi"]
JsArray(Array(1))                 // does not compile

// Map
val map = Map("1" -> "a", "2" -> "b")
Json.toJson(map)     // JsValue = {"1":"a","2":"b"}

// Some
val number = Json.toJson(Some(100))    // JsValue = 100
val number = Json.toJson(Some("Hi"))   // JsValue = "Hi"

// None
val x: Option[Int] = None
val number = Json.toJson(x)            // JsValue = null

