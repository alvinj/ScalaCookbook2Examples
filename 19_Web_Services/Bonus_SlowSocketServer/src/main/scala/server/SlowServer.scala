package server

import java.io.*
import java.net.ServerSocket
import java.util.Date

/** The ability to cancel this code with `ctrl-c` inside of sbt requires you to have this setting in build.sbt:
 *
 *  fork in run := true
 */
@main def SlowSocketServer =
  val serverResponseDelayTimeMs = 1_000
  val serverPort                = 5150

  val server = ServerSocket(serverPort)
  while true do

    println("Waiting at the top of the 'while' loop.")

    // “Listens for a connection to be made to this socket and accepts it”
    val socket = server.accept()

    // simulate a slow server response
    Thread.sleep(serverResponseDelayTimeMs)

    val in  = BufferedReader(InputStreamReader(socket.getInputStream))
    val out = PrintWriter(socket.getOutputStream)

    // this works, but i don’t know if it 100% meets the standard.
    // might need a `\r` at the end of every line.
    out.print(httpResponse(serverResponseDelayTimeMs))
    out.flush()

    // read the input from the client.
    // LazyList used to be known as Stream. can also use Iterator.
    val s = LazyList
      .continually(in.readLine())
      .takeWhile(_.length != 0)
      .mkString("\n")
    println(s"Client said: '$s'")

    println("After reading the client input.\n ")

    out.close
    in.close
    socket.close
end SlowSocketServer

private def httpResponse(serverResponseDelayTimeMs: Int) =
  s"""HTTP/1.1 200 OK
        |Date: ${new Date}
        |Server: SlowServer
        |Content-Type: text/plain
        |Delay-Time: $serverResponseDelayTimeMs ms
        |Connection: Closed
        |
        |Have a nice day!
        |\r\n""".stripMargin
