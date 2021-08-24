package r03_singletons

import com.alvinalexander.simpletest.SimpleTest.*

// p. 220
package t1 {
    object CashRegister:
        def open() = println("opened")
        def close() = println("closed")
        
    @main def main = 
        CashRegister.open()
        CashRegister.close()

}


package t2 {
    object StringUtils:
        def isNullOrEmpty(s: String): Boolean =
            s==null || s.trim.equals("")
        def leftTrim(s: String): String = s.replaceAll("^\\s+", "")
        def rightTrim(s: String): String = s.replaceAll("\\s+$", "") 
        def capitalizeAllWordsInString(s: String): String =
            s.split(" ")
             .map(_.capitalize)
             .mkString(" ")

     @main def stringUtilsTest = 
         // use a StringUtils method without an import
         True(StringUtils.isNullOrEmpty(""))

         // or, import the StringUtils method(s) first, then use it
         import StringUtils.isNullOrEmpty
         True(isNullOrEmpty(""))
}





