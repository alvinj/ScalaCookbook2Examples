# Recipe 24.8, Handling Option Values with Higher-Order Functions


As a setup for those solutions, here are some functions and values that will be used in the table:

```scala
// functions
def p(i: Int): Boolean = i == 1            // type: A => Boolean (a predicate)
def f(i: Int): Int = i * 2                 // type: A => A
def fo(i: Int): Option[Int] = Some(i * 2)  // type: A => Option[A]

// values
val option: Option[Int] = Some(1)
val none: Option[Int] = None

val default = 0
val defaultSome = Some(0)
val stringOption = Option("foo")
```


Examples to show how the HOFs in the third column of the table work:

```scala
option.fold(default)(f)            // 2
none.fold(default)(f)              // 0

option.map(f).getOrElse(default)   // 2
none.map(f).getOrElse(default)     // 0

option.flatMap(i => fo(i))         // Some(2)
none.flatMap(i => fo(i))           // None

option.orElse(defaultSome)         // Some(1)
none.orElse(defaultSome)           // Some(0)

option.forall(p)                   // true
option.find(p)                     // Some(1)
option.filter(p)                   // Some(1)

option.toSeq                       // Seq[Int] = List(1)
none.toSeq                         // Seq[Int] = List()
```





