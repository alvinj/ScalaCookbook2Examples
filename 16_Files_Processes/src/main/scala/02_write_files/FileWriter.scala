package r02_write_files

import java.io.{BufferedWriter, File, FileWriter}

// The first Solution example.
package t1 {
    @main def fileWriter =
        // FileWriter
        val file = File("hello.txt")
        val bw = BufferedWriter(FileWriter(file))
        bw.write("Hello, world\n")
        bw.write("It’s Al")
        bw.close()
        // use this instead to append:
        // val bw = BufferedWriter(FileWriter("notes.txt", true))
}


// The second Solution example.
package t2 {
    @main def nioWrite1 =
        import java.nio.file.{Files,Paths}
        val text = "Hello, world"
        val filepath = Paths.get("nio_paths_files.txt")
        Files.write(filepath, text.getBytes)
}


// The third Solution example.
package t3 {
    import java.nio.file.{Files,Paths,StandardOpenOption}
    import java.nio.charset.StandardCharsets
    import scala.collection.JavaConverters.*

    @main def nioWrite2 =
        // WRITE to a file
        val seq1 = Seq("Hello", "world")
        val filepath = Paths.get("paths_seq.txt")
        Files.write(filepath, seq1.asJava)
        
        // APPEND to the same file
        val seq2 = Seq("It’s", "Al")
        Files.write(
            filepath,
            seq2.asJava,
            StandardCharsets.UTF_8,
            StandardOpenOption.APPEND
        )
}


// The example shown in the Discussion.
package t4 {
    import java.io.*
    import java.nio.charset.StandardCharsets
    
    @main def discussion =
        val bw = BufferedWriter(
            OutputStreamWriter(
                FileOutputStream("discussion.txt"),
                StandardCharsets.UTF_8
            )
        )
        bw.write("Hello, world\n")
        bw.write("It’s Al")
        bw.close()
}



