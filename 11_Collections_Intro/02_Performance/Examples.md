# Recipe 11.2, Understanding the Performance of Collections

On my old computer, this example in the Scala REPL that uses a `Vector` returns almost immediately:

```scala
var a = Vector[Int]()
for i <- 1 to 50_000 do a = a :+ i
```

Conversely, this example — which is identical except that it uses a `List` — takes nearly fifteen seconds to return:

```scala
var b = List[Int]()
for i <- 1 to 50_000 do b = b :+ i
```
