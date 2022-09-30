package r01_collections

@main def properties =

    // [1] create and populate a Java Properties object
    val javaProps = new java.util.Properties
    javaProps.put("first_name", "Charles")
    javaProps.put("last_name", "Carmichael")

    // [2] convert Java Properties to Scala Map
    import scala.jdk.CollectionConverters._
    val scalaProps = javaProps.asScala
    println(scalaProps)
    // for (k,v) <- scalaProps do println(s"key: '$k', value: '$v'")

