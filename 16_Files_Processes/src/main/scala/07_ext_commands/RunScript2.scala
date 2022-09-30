package r07_run_script

// This example is not included in the book, but it shows
// how to run a shell script, which is just like any other
// filesystem command, while also setting its directory and
// the PATH enviroment variable.
package t1 {

  import sys.process
  import java.io.File

  @main def scriptWithEnv =

    // note that if the file you want to execute doesn’t
    // exist, you’ll get an IOException
    val p = process.Process(
      "./show_env.sh",
      File("./resources"),
      "PATH" -> ".:/foo/bar/baz"
    )
    val output = p.!!
    println(s"OUTPUT: $output") // .:/foo/bar/baz (the PATH we set)

}
