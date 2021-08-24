package r05_static_import


package t1 {
    @main def importStatic1 =
        import scala.math.*
        val a = sin(0) // Double = 0.0
        val b = cos(Pi) // Double = −1.0
    
        import java.awt.Color.*
        println(RED) // java.awt.Color[r=255,g=0,b=0]
        println(BLUE) // java.awt.Color[r=0,g=0,b=255]    
}


package t2 {
    object StringUtils:
        def truncate(s: String, length: Int): String = s.take(length)
        def leftTrim(s: String): String = s.replaceAll("^\\s+", "")
        
    @main def objectImportTest =
        import StringUtils.*
        truncate("four score and seven ", 4) // "four"
        leftTrim(" four score and ") // "four score and "
}


package t3 {
    package days {
        enum Day:
            case Sunday, Monday, Tuesday, Wednesday,
                Thursday, Friday, Saturday
    }

    package bar {
       import days.Day.*

       @main def enumImportTest =
          val date = Sunday

          // more code here ...

          if date == Saturday || date == Sunday then
             println("It’s the weekend!")
    }
}


