package xtra_file_io

import java.nio.file.{Files,Paths,Path}
import scala.util.{Try,Success,Failure}

// This is an extra example that shows how to write to
// a file using Paths and Try. It also shows writeToFile
// as a top-level function.


// A top-level function that writes the given text to the
// given filename.
def writeToFile(filename: String, text: String): Try[Path] =
    val filepath = Paths.get(filename)
    Try(Files.write(filepath, text.getBytes))


@main def PathsFunction =
    val filename = "bar.txt"
    val text = "Hello, world"

    // Success(bar.txt)
    // Failure(java.nio.file.NoSuchFileException: /tmp/foo/bar.txt)
    writeToFile(filename, text) match
        case Success(msg) => println(s"Success: $msg")
        case Failure(msg) => System.err.println(s"Error: $msg")


