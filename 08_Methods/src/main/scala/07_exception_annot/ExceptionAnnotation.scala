package r07_exception_annotation


// p. 248
import java.io.*

@throws(classOf[Exception])
def play =
    println("play method")
    // exception throwing code here ...


@throws(classOf[IOException])
@throws(classOf[FileNotFoundException])
def readFile(filename: String) =
    println("readFile method")
    // exception throwing code here ...


