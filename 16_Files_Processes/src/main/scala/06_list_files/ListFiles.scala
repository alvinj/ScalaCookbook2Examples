package r06_list_files

import java.io.File

// All of these 'get' methods assume that `dir` is a 
// directory known to exist.

def getListOfFiles(dir: File): Seq[String] = 
    dir.listFiles
       .filter(_.isFile)
       .map(_.getName)
       .toList

def getListOfFiles(dir: File, extensions: Seq[String]): Seq[File] = 
    dir.listFiles
       .filter(_.isFile)
       .filter(file => extensions.exists(file.getName.endsWith(_)))
       .toList

def getListOfSubDirectories(dir: File): Seq[String] = 
    dir.listFiles
       .filter(_.isDirectory)
       .map(_.getName)
       .toList

@main def listFiles = 
    val listOfFiles = getListOfFiles(File("/tmp"))
    println(listOfFiles)
    
    println(getListOfSubDirectories(File("/tmp")))

