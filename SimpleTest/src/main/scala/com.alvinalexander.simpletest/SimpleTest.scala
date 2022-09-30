package com.alvinalexander.simpletest

/**
 * All of the source code in this file is distributed under the
 * GNU General Public License v3.0. See the LICENSE file in this
 * project, or https://choosealicense.com/licenses/gpl-3.0 for
 * more details.
 * 
 * Created by Alvin J. Alexander, https://alvinalexander.com
 */
package support {
    val AnsiRed   = "\u001B[31m"
    val AnsiGreen = "\u001B[32m"
    val AnsiYellow = "\u001B[33m"
    val AnsiReset = "\u001B[0m"
    def printRed(s: String)    = println(s"${AnsiRed}${s}${AnsiReset}")
    def printGreen(s: String)  = println(s"${AnsiGreen}${s}${AnsiReset}")
    def printYellow(s: String) = println(s"${AnsiYellow}${s}${AnsiReset}")
}

import support._

object SimpleTest:

    private def _True(
        blockOfTestCode: => Boolean, 
        trueString: String,
        falseString: String
    ): Unit =
        if blockOfTestCode then
            printGreen(trueString)
        else
            printRed(falseString)
        end if

    /**
     * Assert that an expression is true.
     * @param blockOfTestCode The expression to test.
     * @param num The test number.
     */
    def True(blockOfTestCode: => Boolean, num: Int): Unit =
        _True(
            blockOfTestCode,
            s"(true)  test $num",
            s"(false) test $num"
        )

    /**
     * Assert that an expression is true.
     * @param blockOfTestCode The expression to test.
     * @param desc The test description.
     */
    def True(blockOfTestCode: => Boolean, desc: String): Unit =
        _True(
            blockOfTestCode,
            s"(true)  $desc",
            s"(false) $desc"
        )

    private def _False(
        blockOfTestCode: => Boolean, 
        trueString: String,
        falseString: String
    ): Unit =
        if blockOfTestCode == false then
            printGreen(trueString)
        else
            printRed(falseString)
        end if

    /**
     * Assert that an expression is false.
     * @param blockOfTestCode The expression to test.
     * @param num The test number.
     */
    def False(blockOfTestCode: => Boolean, num: Int): Unit =
        _False(
            blockOfTestCode,
            s"(true)  test $num",
            s"(false) test $num"
        )

    /**
     * Assert that an expression is false.
     * @param blockOfTestCode The expression to test.
     * @param desc The test description.
     */
    def False(blockOfTestCode: => Boolean, desc: String): Unit =
        _False(
            blockOfTestCode,
            s"(true)  $desc",
            s"(false) $desc"
        )

    /**
     * Assert that the two given values are equal (`==`).
     * @param expected The expected result.
     * @param actual The actual result.
     * @param desc A description of the test.
     */
    def Equals(expected: Any, actual: Any, desc: String): Unit =
        if expected == actual then
            printGreen(s"(true) $desc")
        else
            printRed(s"(false) EXPECTED: ($expected), ACTUAL: ($actual), DESC: $desc")
        end if

    def Todo(desc: String): Unit =
        printYellow(s"TODO:   $desc")


    /**
     * This is a different approach so you don’t have to supply
     * a description. Just let this object keep track of the
     * test numbers for you.
     */
    private var testCount = 0
    def True(blockOfTestCode: => Boolean): Unit =
        testCount += 1
        if blockOfTestCode then
            printGreen(s"(true)  test $testCount")
        else
            printRed(s"(false) test $testCount")
        end if
    def False(blockOfTestCode: => Boolean): Unit =
        testCount += 1
        if blockOfTestCode == false then
            printGreen(s"(true)  test $testCount")
        else
            printRed(s"(false) test $testCount")
        end if

    /**
     * Assert that the two given values are equal (`==`).
     * @param expected The expected result.
     * @param actual The actual result.
     */
    def Equals(expected: Any, actual: Any): Unit =
        //TODO decide on what output you want to see here
        testCount += 1
        if expected == actual then
            printGreen(s"(true) EXPECTED: ($expected), ACTUAL: ($actual)")
        else
            printRed(s"(false) EXPECTED: ($expected), ACTUAL: ($actual)")
        end if

end SimpleTest





