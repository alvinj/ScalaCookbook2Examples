package r01_collections

// i put these in separate packages so i can verify which import
// statements are required
package t1 {
  import scala.jdk.CollectionConverters._
  import java.util.List
  // import scala.collection.mutable.Buffer

  def javaIntegerToScalaInt(i: Integer): Int = i

  @main def testList =
    println("Using a Java List in Scala")
    val jlist: java.util.List[Integer] = JavaCollections.getNumbers
    // jlist.getClass is "class java.util.ArrayList"
    // println(jlist.getClass)         //class java.util.ArrayList
    // println(jlist.get(0).getClass)  //class java.lang.Integer

    // note that this is `Seq[Integer]` and not `Seq[Int]`:
    val slist: Seq[Integer] = jlist.asScala.toSeq
    slist.foreach(println)

    // // TODO: this won’t compile because i have INTEGER and want INT:
    // // println(s"absolute value of first element: ${slist(0).abs}")
    val xs: Seq[Int] = slist.map(i => javaIntegerToScalaInt(i))
    println(xs)
    println(s"absolute value of first element: ${xs(0).abs}") // works
    // println(s"absolute value of first element: ${xs(0).getClass}") // works

}

package t2 {
  import scala.jdk.CollectionConverters._
  import java.util.{ Map => JavaMap }
  import scala.collection.mutable.{ Map => ScalaMap }

  @main def testMap =
    println("use a Java Map in Scala")
    // JavaCollections is my class in the same package; see src/main/java
    val jmap: JavaMap[String, String]  = JavaCollections.getPeeps
    val smap: ScalaMap[String, String] = jmap.asScala
    for (k, v) <- smap do println(s"key: '$k', value: '$v'")

}
