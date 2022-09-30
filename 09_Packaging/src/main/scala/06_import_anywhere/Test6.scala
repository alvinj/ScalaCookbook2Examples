package r06_6

package foo

// available to all classes defined below
import java.io.File
import java.io.PrintWriter

class Foo:
    // only available inside this class
    import javax.swing.JFrame
    // ...

class Bar:
    // only available inside this class
    import scala.util.Random
    // ...

