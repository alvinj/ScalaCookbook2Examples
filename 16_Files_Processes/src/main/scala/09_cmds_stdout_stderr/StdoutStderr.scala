package r09_stdout_stderr


// page 483
package t1 {
    @main def stdoutStderr =
        import sys.process.*

        val stdout = StringBuilder()
        val stderr = StringBuilder()

        val status = "ls -al . cookies" ! ProcessLogger(stdout append _, stderr append _)
        println(s"status: '$status'")
        println(s"stdout: '$stdout'")
        println(s"stderr: '$stderr'")
}


// page 484
package t2 {
    @main def stdoutStderrSeq =
        import sys.process.*

        val stdout = StringBuilder()
        val stderr = StringBuilder()

        val status = Seq(
            "find",
            "/usr",
            "-name",
            "make"
        ) ! ProcessLogger(stdout append _, stderr append _)

        println(s"status: '$status'")
        println(s"stdout: '$stdout'")
        println(s"stderr: '$stderr'")
}


// page 485
package t3 {
    @main def stdoutStderrArgs =
        import sys.process.*

        val stdout = StringBuilder()
        val stderr = StringBuilder()

        val status = "ls -al . cookie".!(ProcessLogger(
                arg1 => stdout.append(arg1),
                arg2 => stderr.append(arg2)
            )
        )

        println(s"STATUS: '$status'")
        println(s"STDOUT: '$stdout'")
        println(s"STDERR: '$stderr'")
}





