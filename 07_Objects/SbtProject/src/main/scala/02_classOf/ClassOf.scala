package r02_classof

import com.alvinalexander.simpletest.SimpleTest.*

// p. 219
package t1 {
    @main def classOfTest =
        val stringClass: Class[String] = classOf[String]
        val methods = stringClass.getMethods
        methods.foreach(println)
}

