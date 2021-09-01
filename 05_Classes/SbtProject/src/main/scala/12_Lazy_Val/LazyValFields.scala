package r12_assigning_lazy_field


// p. 168
package t1 {
    import scala.io.Source

    class FileReader(filename: String):
        // assign this block of code to the 'text' field.
        // notice that it is not 'lazy'.
        val text =
            // 'fileContents' will either contain the file contents, 
            // or the exception message as a string
            val fileContents =
                try
                    // [1] return the file contents ...
                    Source.fromFile(filename).getLines.mkString
                catch
                    case e: Exception => 
                        // [2] or return the error message
                        e.getMessage
            println(fileContents) // print the contents
            fileContents // return the contents from the block

    @main def classFieldTest =
        // because `text` IS NOT lazy, there IS output when
        // this is run
        val reader = FileReader("/etc/passwd")
}




// p. 168 (lazy val)
package t2 {
    import scala.io.Source

    class FileReader(filename: String):
        // the only difference from the previous example is that
        // this field is defined as 'lazy'
        lazy val text =
            // 'fileContents' will either contain the file contents, 
            // or the exception message as a string
            val fileContents =
                try
                    // [1] return the file contents ...
                    Source.fromFile(filename).getLines.mkString
                catch
                    case e: Exception => 
                        // [2] or return the error message
                        e.getMessage
            println(fileContents) // print the contents
            fileContents // return the contents from the block

    @main def classFieldTest =
        // because `text` IS lazy, there IS NO output when
        // this is run
        val reader = FileReader("/etc/passwd")
}



