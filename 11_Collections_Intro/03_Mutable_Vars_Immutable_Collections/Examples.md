# Recipe 11.3, Understanding Mutable Variables with Immutable Collections

(These are a few notes from this recipe.)


For instance, when you create a `var` field with an immutable `Vector`, it appears you can somehow add new elements to the `Vector`:

```scala
var x = Vector(1)     // x: Vector(1)
x = x :+ 2            // x: Vector(1, 2)
x = x ++ List(3, 4)   // x: Vector(1, 2, 3, 4)
```


The end result is similar to these lines of code:

```scala
var x = Vector(1)
x = Vector(1, 2)         // reassign x
x = Vector(1, 2, 3, 4)   // reassign x again
```
