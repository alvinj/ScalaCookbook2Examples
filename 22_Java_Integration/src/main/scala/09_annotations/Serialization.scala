package r09_annotations

// p. 664
// this code ignores possible exceptions
def deepClone(obj: Object): Object =
  import java.io.*
  // [1] write the stream out
  val baos = new ByteArrayOutputStream()
  val oos  = new ObjectOutputStream(baos)
  oos.writeObject(obj)
  // [2] read the stream back in
  val bais = new ByteArrayInputStream(baos.toByteArray())
  val ois  = new ObjectInputStream(bais)
  ois.readObject()

// p. 664
package t1 {

  @SerialVersionUID(123L)
  class Sheep(val name: String) extends Serializable:
    override def toString = name
    // `@transient`: "denote a field that shall not be serialized"
    @transient val greet: String = {
      // if you don’t make this transient,
      // this will be null after serialization/deserialization
      println("Sheep::greet")
      s"Hello, $name"
    }

  @main def serializeASheep =
    println("--- BEFORE SERIALIZATION ---")
    val d = Sheep("Dotty")
    println("sheep.toString:  " + d)
    println("sheep.greet:     " + d.greet)

    println("--- AFTER SERIALIZATION ---")
    val d2 = deepClone(d).asInstanceOf[Sheep]
    println("sheep2.toString: " + d2)
    println("sheep2.greet:    " + d2.greet) // this should be null

    // shows how to print the @SerialVersionUID of a class
    println(java.io.ObjectStreamClass.lookup(d2.getClass()).getSerialVersionUID())

}

// p. 665
package t2 {

  class Cat(val name: String):
    override def toString = name

  // This attempt fails because it does not use @SerialVersionUID
  // and Serializable.
  @main def tryToSerializeCat =
    val c  = Cat("Morris")
    val c2 = deepClone(c) // error: java.io.NotSerializableException

}

// p. 665
package t3 {

  @SerialVersionUID(123L)
  class Sheep(val name: String) extends Serializable:
    override def toString = name
    // the only change in the code is to make this 'lazy':
    @transient lazy val greet: String = {
      println("Sheep::greet")
      s"Hello, $name"
    }

  @main def serializeASheep =
    println("--- BEFORE SERIALIZATION ---")
    val d = Sheep("Dotty")
    println("sheep.toString:  " + d)
    println("sheep.greet:     " + d.greet)

    println("--- AFTER SERIALIZATION ---")
    val d2 = deepClone(d).asInstanceOf[Sheep]
    println("sheep2.toString: " + d2)
    println("sheep2.greet:    " + d2.greet) // this should work now

}
