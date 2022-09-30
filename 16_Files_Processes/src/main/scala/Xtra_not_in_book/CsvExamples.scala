package xtra

// These are some extra examples I created that are not
// included in the Scala Cookbook, but hopefully they can
// be a starting point if you ever need to work with CSV
// files.
package t1 {
  @main def csv =
    println("Month, Income, Expenses, Profit")
    val bufferedSource = io.Source.fromFile("finance.csv")
    for
      line <- bufferedSource.getLines()
      if line.trim != ""
      cols = line.split(",").map(_.trim)
    // do whatever you want with the columns here
    do println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
    bufferedSource.close
}

package t2 {
  @main def csv =
    println("Month, Income, Expenses, Profit")
    val bufferedSource = io.Source.fromFile("finance.csv")
    for
      line <- bufferedSource.getLines()
      if line.trim != ""
      Array(month, revenue, expenses, profit) = line.split(",").map(_.trim)
    do println(s"$month $revenue $expenses $profit")
    bufferedSource.close
}
