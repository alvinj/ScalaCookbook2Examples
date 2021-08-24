package r04_string_as_file

import com.alvinalexander.simpletest.SimpleTest.*


// The source code from the Solution.
package t1 {
    import scala.io.Source

    def printLines(source: Source): Unit =
        for line <- source.getLines do
            println(line)

    @main def stringAndFileSources =    
        // call printLines with a String source
        val stringSource = Source.fromString("foo\nbar\n")
        printLines(stringSource)
    
        // call printLines with a File source
        val fileSource = Source.fromFile("foo.txt")
        printLines(fileSource)
}


// The source code from the Discussion.
package t2 {
    import scala.io.Source

    object FileUtils:
        def getLinesUppercased(source: io.Source): List[String] =
            source.getLines.map(_.toUpperCase).toList

    @main def stringAndFileSources2 =
        // yikes, a null! :)
        var source: Source = null
    
        // test with a File
        source = Source.fromFile("foo.txt")
        val fileLines = FileUtils.getLinesUppercased(source)
        True(fileLines(0) == "FOO")
    
        // test with a String
        source = Source.fromString("foo\n")
        val stringLines = FileUtils.getLinesUppercased(source)
        True(stringLines(0) == "FOO")
}







