# Recipe 12.3, Adding Elements to a List

The preferred approach is to prepend elements with the `::` method, while assigning the results to a new `List`:

```scala
val a = List(2)              // a: List(2)

// prepend with ::
val b = 1 :: a               // b: List(1, 2)
val c = 0 :: b               // c: List(0, 1, 2)
```

You can also use the `:::` method to prepend one list in front of another:

```scala
val a = List(3, 4)           // a: List(3, 4)
val b = List(1, 2) ::: a     // b: List(1, 2, 3, 4)
```

Rather than continually reassigning the result of prepend operations to a new variable, you can declare your variable as a `var`, and reassign the result to it:

```scala
var x = List(5)              // x: List[Int] = List(5)
x = 4 :: x                   // x: List(4, 5)
x = 3 :: x                   // x: List(3, 4, 5)
x = List(1, 2) ::: x         // x: List(1, 2, 3, 4, 5)
```

The `::` and `:::` methods are right-associative — lists are constructed from right to left, which you can see more clearly in these example:

```scala
val a = 3 :: Nil             // a: List(3)
val b = 2 :: a               // b: List(2, 3)
val c = 1 :: b               // c: List(1, 2, 3)
val d = 1 :: 2 :: Nil        // d: List(1, 2)
```

To be clear about how `::` and `:::` work, it can help to know that the Scala compiler converts the code in this first example to the code shown in the second example:

```scala
List(1, 2) ::: List(3, 4)    // what you type
List(3, 4).:::(List(1, 2))   // how the compiler interprets that code
```

Both result in a `List(1,2,3,4)`.



## Discussion

This style of creating a list has its roots in the Lisp programming language:

```scala
val x = 1 :: 2 :: 3 :: Nil   // x: List(1, 2, 3)
```


### Other methods to prepend, append

Though using `::` and `:::` are the common methods to use with lists, there are additional methods that let you prepend or append single elements to a `List`:

```scala
val x = List(1)

// prepend
val y = 0 +: x   // y: List(0, 1)

// append
val y = x :+ 2   // y: List(1, 2)
```

If don’t work with the `List` class a lot, another way to concatenate two lists into a new list is with the `++` or `concat` methods:

```scala
val a = List(1, 2, 3)
val b = List(4, 5, 6)

// '++' is an alias for 'concat', so they work the same
val c = a ++ b        // c: List(1, 2, 3, 4, 5, 6)
val c = a.concat(b)   // c: List(1, 2, 3, 4, 5, 6)
```

Because these methods are used consistently across immutable collections, they can be easier to remember.


#### Methods that end in :

Any Scala method that ends with a `:` character is evaluated from _right to left_. This means that the method is invoked on the right operand. You can see how this works by analyzing the following code, where both methods print the number `42`:

```scala
@main def rightAssociativeExample =
    val p = Printer()
    p >> 42     // prints "42"
    42 >>: p    // prints "42"

class Printer:
    def >>(i: Int) = println(s"$i")
    def >>:(i: Int) = println(s"$i")
```

In addition to using the methods as shown in that example, the two methods can also be invoked like this:

```scala
p.>>(42)
p.>>:(42)
```

In summary, by defining the second method to end in a colon, it can be used as a right-associative operator.




