package tests

import com.alvinalexander.simpletest.SimpleTest._

@main def tests =

    // run tests and give them descriptions
    True(1 == 1,  "1 == 1 (expecting green)")
    True(1 == 2,  "1 == 2 (expecting red)")
    False(1 == 2, "1 == 2 (expecting green)")
    False(1 == 1, "1 == 1 (expecting red)")
    Equals(1, 1,  "i expect green")
    Equals(1, 2,  "i expect red here")
    Todo("don’t forget to test 2 == 3")
    
    // run tests but only give them numbers
    True(1 == 1,   1)
    True(2 == 2,   2)
    True(3 == 3,   3)
    False(1 == 7,  4)
    False(1 == 8,  5)
    False(6 == 60, 6)

    // numbering is too much work, just let the object 
    // keep track of the test numbers
    True(1 == 1)
    False(1 == 2)
    Equals(1, 1)

package t1 {
import com.alvinalexander.simpletest.SimpleTest._

    @main def tests =

        // use `True` to assert that an expression is true
        True(1 == 1,  "1 == 1 (expecting green)")
        True(1 == 2,  "1 == 2 (expecting red)")

        // use `False` to assert that an expression is false
        False(1 == 2, "1 == 2 (expecting green)")
        False(1 == 1, "1 == 1 (expecting red)")

        // use `Equals` to assert that two objects are `==`
        Equals(1, 1,  "i expect green")
        Equals(1, 2,  "i expect red here")

        // in case you want to note tests that you intend to run
        Todo("don’t forget to test 2 == 3")

        // just run some tests and simpletest will keep track of
        // the test numbers for you
        True(1 == 1)
        False(1 == 2)
        Equals(1, 1)

}