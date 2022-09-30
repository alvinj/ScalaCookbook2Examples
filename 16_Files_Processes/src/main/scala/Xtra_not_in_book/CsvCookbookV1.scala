// package xtra

// These are some examples I created for the
// 1st Edition of the Scala Cookbook. They may also
// be a good starting point for working with CSV files.

// object Csv1 extends App {
//     println("Month, Income, Expenses, Profit")
//     val bufferedSource = io.Source.fromFile("finance.csv")
//     for (line <- bufferedSource.getLines) {
//         val cols = line.split(",").map(_.trim)
//         // do whatever you want with the columns here
//         println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
//     }
//     bufferedSource.close
// }
//
//
// object Csv2 extends App {
//     println("Month, Income, Expenses, Profit")
//     val bufferedSource = io.Source.fromFile("finance.csv")
//     for (line <- bufferedSource.getLines) {
//         val Array(month, revenue, expenses, profit) = line.split(",").map(_.trim)
//         println(s"$month $revenue $expenses $profit")
//     }
//     bufferedSource.close
// }
//
//
// object Csv3 extends App {
//     val nrows = 3
//     val ncols = 4
//     val rows = Array.ofDim[String](nrows, ncols)
//
//     val bufferedSource = io.Source.fromFile("finance.csv")
//     var count = 0
//     for (line <- bufferedSource.getLines) {
//         rows(count) = line.split(",").map(_.trim)
//         count += 1
//     }
//     bufferedSource.close
//
//     // print the rows
//     for (i <- 0 until nrows) {
//         println(s"${rows(i)(0)} ${rows(i)(1)} ${rows(i)(2)} ${rows(i)(3)}")
//     }
// }
//
//
// object Csv4 extends App {
//     val nrows = 3
//     val ncols = 4
//     val rows = Array.ofDim[String](nrows, ncols)
//
//     val bufferedSource = io.Source.fromFile("finance.csv")
//     for ((line, count) <- bufferedSource.getLines.zipWithIndex) {
//         rows(count) = line.split(",").map(_.trim)
//     }
//     bufferedSource.close
//
//     // print the rows
//     for (i <- 0 until nrows) {
//         println(s"${rows(i)(0)} ${rows(i)(1)} ${rows(i)(2)} ${rows(i)(3)}")
//     }
// }
//
//
// import scala.collection.mutable.ArrayBuffer
// object Csv5 extends App {
//
//     // each row is an array of strings (the columns in the csv file)
//     val rows = ArrayBuffer[Array[String]]()
//
//     // (1) read the csv data
//     using(io.Source.fromFile("finance.csv")) { source =>
//             for (line <- source.getLines) {
//             rows += line.split(",").map(_.trim)
//         }
//     }
//
//     // (2) print the results
//     for (row <- rows) {
//         println(s"${row(0)}|${row(1)}|${row(2)}|${row(3)}")
//     }
//
//     // required when using reflection, like `using` does
//     import scala.language.reflectiveCalls
//     def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B =
//     try {
//         f(resource)
//     } finally {
//         resource.close()
//     }
// }
