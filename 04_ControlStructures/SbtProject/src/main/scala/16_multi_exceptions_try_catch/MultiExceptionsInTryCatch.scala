package r16_multi_exceptions_try_catch

import java.io.*

def openAndReadAFile(filename: String) =
    io.Source.fromFile(filename).getLines


package t1 {
    @main def tryMultiExceptions1 =
        val filename = "/etc/foo"
        try
            openAndReadAFile(filename)
        catch
            case e: (FileNotFoundException | IOException) =>
                println(s"Had an IOException trying to read $filename")
}


package t2 {
    @main def tryMultiExceptions2 =
        val filename = "/etc/foo"
        try
            openAndReadAFile(filename)
        catch
            case e: FileNotFoundException =>
                println(s"Couldn’t find $filename.")
            case e: IOException => 
                println(s"Had an IOException trying to read $filename.")
}


package read_file {

    import scala.io.Source
    import java.io.{FileNotFoundException, IOException}

    def readFile(filename: String): Option[String] =
        try
            Some(Source.fromFile(filename).getLines.mkString)
        catch
            case _: (FileNotFoundException|IOException) => None

    @main def readFileMain = 
        println("/ETC/PASSWORD:")
        println("--------------")
        val f1: Option[String] = readFile("/etc/passwd")
        f1.foreach(content => println(content.take(80)))

        // you won’t get any output here, because /etc/foo doesn’t exist
        println("/ETC/FOO:")
        println("---------")
        val f2: Option[String] = readFile("/etc/foo")
        f2.foreach(println)

}


package read_file_try {
    import scala.io.Source
    import java.io.{FileNotFoundException, IOException}
    import scala.util.{Try,Success,Failure}

    def readFile(filename: String): Try[String] =
        try
            Success(Source.fromFile(filename).getLines.mkString)
        catch
            case t: Throwable => Failure(t)

    @main def readFileTry = 
        println("/ETC/PASSWORD:")
        println("--------------")
        val f1: Try[String] = readFile("/etc/passwd")
        f1.foreach(content => println(content.take(80)))

        // you won’t get any output here, because /etc/foo doesn’t exist
        println("/ETC/FOO:")
        println("---------")
        val f2: Try[String] = readFile("/etc/foo")
        f2.foreach(println)
        println(f2)
}


package read_file_bad {
    import scala.io.Source
    import java.io.{FileNotFoundException, IOException}
    def readFile(filename: String): String =
        try
            Source.fromFile(filename).getLines.mkString
        catch
            case t: Throwable => throw t

    @throws(classOf[NumberFormatException])
    def readFile2(filename: String): String =
        try
            Source.fromFile(filename).getLines.mkString
        catch
            case t: Throwable => throw t

}



