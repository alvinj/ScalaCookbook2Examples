package r04_default_values

// p. 244
package t1 {
  class Connection:
    def makeConnection(timeout: Int = 5_000, protocol: String = "https") =
      println(f"timeout = ${timeout}%d, protocol = ${protocol}%s")
    // more code here

  @main def defaultValues =
    val c = Connection()
    c.makeConnection()              // timeout = 5000, protocol = https
    c.makeConnection(2_000)         // timeout = 2000, protocol = https
    c.makeConnection(3_000, "http") // timeout = 3000, protocol = http

    // can also use named parameters
    c.makeConnection(timeout = 10_000)
    c.makeConnection(protocol = "http")
    c.makeConnection(timeout = 10_000, protocol = "http")
    c.makeConnection(protocol = "http", timeout = 10_000)

}

// p. 245
package t2 {
  class Connection:
    // correct implementation, default value is listed last
    def makeConnection(timeout: Int, protocol: String = "https") =
      println(f"timeout = ${timeout}%d, protocol = ${protocol}%s")

  @main def mixedStyles =
    val c = Connection()
    c.makeConnection(1_000)         // timeout = 1000, protocol = https
    c.makeConnection(1_000, "http") // timeout = 1000, protocol = http

}
