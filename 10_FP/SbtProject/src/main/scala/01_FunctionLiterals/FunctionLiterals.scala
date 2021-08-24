package r01_function_literals

import com.alvinalexander.simpletest.SimpleTest.*


// pp. 279-280
package t1 {
    @main def evens =
        // a list of 1..9
        val x = List.range(1, 10)

        // get only the even values, the long form
        val evens1 = x.filter((i: Int) => i % 2 == 0)
        Equals(evens1, List(2, 4, 6, 8))

        // the short form
        val evens2 = x.filter(_ % 2 == 0)
        Equals(evens2, List(2, 4, 6, 8))
}


// pp. 280-281
package t2 {
    @main def maps =
        val map = Map(1 -> 10, 2 -> 20, 3 -> 30)

        // the transform method takes two parameters as a tuple
        val newMap = map.transform((k,v) => k + v)
        Equals(newMap, Map(1 -> 11, 2 -> 22, 3 -> 33))

        // here 'x' is a tuple
        map.foreach(x => println(s"${x._1} --> ${x._2}"))
}




