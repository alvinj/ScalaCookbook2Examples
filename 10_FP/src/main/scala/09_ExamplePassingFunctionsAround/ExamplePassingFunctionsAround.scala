package r09_ex_passing_functions_around

import com.alvinalexander.simpletest.SimpleTest.*


/**
 * Newton’s Method for solving equations.
 * @param fx The equation to solve.
 * @param fxPrime The derivative of `fx`.
 * @param x An initial “guess” for the value of `x`.
 * @param tolerance Stop iterating when the iteration values are 
          within this tolerance.
 * @todo Check that `f(xNext)` is greater than a second tolerance value.
 * @todo Check that `f'(x) != 0`
 */
def newtonsMethod(
    fx: Double => Double,        // a function
    fxPrime: Double => Double,   // a function
    x: Double,
    tolerance: Double
): Double = 
    /**
     * most FP approaches don’t use a `var` field,
     * but some people believe that `var` fields are acceptable
     * when they are contained within the scope of a method/function.
     */
    var x1 = x
    var xNext = newtonsMethodHelper(fx, fxPrime, x1)
    while math.abs(xNext - x1) > tolerance do
        x1 = xNext
        println(xNext)   // debugging (intermediate values)
        xNext = newtonsMethodHelper(fx, fxPrime, x1)
    end while
    // return xNext:
    xNext
end newtonsMethod


/**
 * This is the `x2 = x1 - f(x1)/f'(x1)` calculation.
 */
def newtonsMethodHelper(
    fx: Double => Double,        // a function
    fxPrime: Double => Double,   // a function
    x: Double
): Double = 
    x - fx(x) / fxPrime(x)


/**
 * A “driver” function to test Newton’s method. Start with:
 *   - the desired `f(x)` and `f'(x)` equations
 *   - an initial guess, and 
 *   - a tolerance value
 */
@main def driver =
    // The `f(x)` and `f'(x)` functions. Both functions take a `Double`
    // parameter named `x` and return a `Double`.
    def fx(x: Double): Double = 3*x + math.sin(x) - math.pow(math.E, x)
    def fxPrime(x: Double): Double = 3 + math.cos(x) - math.pow(math.E, x)

    val initialGuess = 0.0
    val tolerance = 0.00005

    // pass `f(x)` and `f'(x)` to the Newton’s Method function, along with
    // the initial guess and tolerance.
    val answer = newtonsMethod(fx, fxPrime, initialGuess, tolerance)

    // note: this is not an FP approach to printing output
    println(answer)





