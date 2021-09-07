# Recipe 15.6, Creating and Using a Stack


An empty mutable stack:

```scala
import scala.collection.mutable.Stack
val ints = Stack[Int]()
val strings = Stack[String]()
```

Populate a stack with initial elements:

```scala
val chars = Stack('a', 'b', 'c')      // Stack[Char] = Stack(a, b, c)
val ints = Stack(1, 2, 3)             // Stack[Int] = Stack(1, 2, 3)
val ints: Stack[Int] = Stack(1,2,3)   // Stack[Int] = Stack(1, 2, 3)
```

Once you have a mutable stack, push elements onto it with `push`:

```scala
import scala.collection.mutable.Stack
val s = Stack[String]()   // s: Stack[String] = Stack()

// add one element at a time
s.push("a")               // s: Stack(a)
s.push("b")               // s: Stack(b, a)

// add multiple elements
s.push("c", "d")          // s: Stack(d, c, b, a)
```

Pop elements off the stack:

```scala
val next = s.pop          // next=d, s=Stack(c, b, a)
```

Peek at the next element using `top`:

```scala
val top = s.top           // top=c, s=Stack(c, b, a)
```

Empty a mutable stack with `clear` or `clearAndShrink`:

```scala
// creates a stack from 0 to 999_999
val nums = Stack.range(0, 1_000_000)

nums.clear                // nums: Stack[String] = Stack()
nums.clearAndShrink(0)    // nums: Stack[String] = Stack()
```


## Other methods

`Stack` has dozens of other methods:

```scala
val s = Stack("apple", "banana", "kiwi")

s.size                   // 3
s.isEmpty                // false
s.count(_.length > 4)    // 2
s.filter(_.length > 4)   // Stack(apple, banana)
```

Examples:

```scala
val s = Stack[Int]()        // s: collection.mutable.Stack[Int] = Stack()
s.push(1)                   // s: Stack(1)
s.push(2,3)                 // s: Stack(3, 2, 1)
s.pushAll(List(4,5))        // s: Stack(5, 4, 3, 2, 1)
val a = s.pop               // a=5, s=Stack(4, 3, 2, 1)
val b = s.popWhile(_ > 2)   // b=List(4, 3), s=Stack(2, 1)
val c = s.popAll            // c=List(1, 2), s=Stack()
```





