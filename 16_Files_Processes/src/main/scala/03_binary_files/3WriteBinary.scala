// package r03_binary_files
//
// import java.io.File
// import java.io.FileOutputStream
// import java.io.IOException
// import scala.util.{Try, Success, Failure}
// import java.nio.charset.StandardCharsets
// import java.nio.file.{Files,Path,Paths,StandardOpenOption}
//
//
// // This is some extra code that I used to test file-writing
// // performance. Note that large examples are INSANELY SLOW
// // without BufferedOutputStream.
// @main def WriteBinary =
//     val filename = "WriteBinary.dat"
//     val data = "foo bar".getBytes(StandardCharsets.UTF_8)
//     writeBinary1(filename, data)
//     writeBinary2(filename, data)
//
// // A benefit of FileOutputStream is that you can write one byte at
// // a time (but always wrap it with BufferedOutputStream).
// def writeBinary1(filename: String, data: Array[Byte]): Try[Unit] =
//     Try {
//         val fos = FileOutputStream(File(filename))
//         fos.write(data)
//         fos.close
//     }
//
// // Note that this approach returns Path rather than Unit.
// def writeBinary2(filename: String, data: Array[Byte]): Try[Path] =
//     Try {
//         val path = Paths.get(filename)
//         Files.write(path, data, StandardOpenOption.WRITE)
//     }
//
//
//
