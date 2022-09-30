package r05_serialization

import java.io.*
import com.alvinalexander.simpletest.SimpleTest.*

// create a serializable Stock class
@SerialVersionUID(1L)
class Stock(var symbol: String, var price: BigDecimal) extends Serializable:
  override def toString = f"$symbol%s is ${price.toDouble}%.2f"

// test writing that class out and then reading it back in again
@main def serializationDemo =
  val filename = "nflx.obj"

  // (1) create a Stock instance
  val nflx = Stock("NFLX", BigDecimal(300.15))

  // (2) write the instance out to a file
  val oos = ObjectOutputStream(FileOutputStream(filename))
  oos.writeObject(nflx)
  oos.close

  // (3) read the object back in
  val ois   = ObjectInputStream(FileInputStream(filename))
  val stock = ois.readObject.asInstanceOf[Stock]
  ois.close

  // (4) test the object that was read back in
  True(stock.symbol == "NFLX")
  True(stock.price == 300.15)
