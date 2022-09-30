package r03_binary_files

// note that working with large files can be ridiculously
// slow if you don’t use buffering.

// Example 1, reading a binary file.
package t1 {
  import java.io.{ BufferedInputStream, FileInputStream }

  @main def readBinary1 =
    val bis = BufferedInputStream(FileInputStream("/etc/passwd"))
    Iterator
      .continually(bis.read())
      .takeWhile(_ != -1)
      .foreach(b => b) // do whatever you want with each byte
    bis.close()
}

// Example 2, writing to a binary file.
package t2 {
  import java.io.{ BufferedOutputStream, FileOutputStream }

  @main def writeBinary =
    // write a binary file
    val filename = "file.dat"
    val bos      = BufferedOutputStream(FileOutputStream(filename))
    val bytes    = "Hello, world".getBytes
    bytes.foreach(b => bos.write(b))
    bos.close

    // as a test, read it back in
    import java.io.{ FileInputStream, BufferedInputStream }
    val bis = BufferedInputStream(FileInputStream(filename))
    Iterator
      .continually(bis.read())
      .takeWhile(_ != -1)
      .foreach(b => println(b.toChar))
    bis.close()
}

// Here’s a binary file reading example using Paths & Files.
package t3 {
  import java.io.FileInputStream
  import java.io.BufferedInputStream
  import java.io.IOException
  import scala.util.{ Failure, Success, Try }
  import java.nio.charset.StandardCharsets
  import java.nio.file.{ Files, Paths, StandardOpenOption }

  @main def readBinary2 =
    val path        = Paths.get("/etc/passwd")
    val inputStream = Files.newInputStream(path, StandardOpenOption.READ)
    val bis         = new BufferedInputStream(inputStream)
    Iterator
      .continually(bis.read())
      .takeWhile(_ != -1)
      .foreach(b => b) // do whatever you want with each byte
    bis.close()
    inputStream.close()
}
