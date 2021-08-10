package r17_try_catch

import scala.io.Source
import java.io.*

@main def readAFile() =
    var sourceOption: Option[Source] = None
    try
        sourceOption = Some(Source.fromFile("/etc/passwd"))
        sourceOption.foreach { source =>
            for line <- source.getLines do println(line.toUpperCase)
        }
    catch
        case ioe: IOException => ioe.printStackTrace
        case fnf: FileNotFoundException => fnf.printStackTrace
    finally
        println("entered finally ...")
        sourceOption match 
            case None =>
                println("bufferedSource == None")
            case Some(s) => 
                println("closing the bufferedSource ...")
                s.close

