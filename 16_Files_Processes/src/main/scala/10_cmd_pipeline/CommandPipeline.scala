package r10_cmd_pipeline


// page 486
package t1 {
    @main def cmdPipeline =
        import sys.process.*
        val numRootProcs = ("ps aux" #| "grep root" #| "wc -l").!!.trim
        println(s"# root procs: $numRootProcs")

        // other options to list the 'root' procs:
        // val rootProcs: String = ("ps auxw" #| "grep root").!!.trim
        // val rootProcs: LazyList[String] = ("ps auxw" #| "grep root").lazyLines
}


// this is the last example on page 486.
// this works as desired, executing a shell and then piping
// the 'ps' output into 'grep':
// val result = Seq(
//     "/bin/sh",
//     "-c",
//     "ps aux | grep root"
// ).!!


// this example, which was not included in the book, 
// shows how to use `#>` to redirect process output to a file
package t4 {
    import sys.process.*
    import java.net.URL
    import java.io.File

    @main def redirectOutputUrl =
        val outfile = "UrlOut.html"
        val exitCode = (URL("https://www.google.com") #> File(outfile)).!

}



