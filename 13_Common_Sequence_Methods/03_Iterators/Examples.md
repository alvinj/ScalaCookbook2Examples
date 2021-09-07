# Recipe 13.3, Using Iterators


Scala developers don’t normally call `hasNext` and `next` ... conversely, I do write code like this:

```scala
val a = it.map(_ * 2)             // a: Iterator[Int] = <iterator>
val b = it.filter(_ > 2)          // b: Iterator[Int] = <iterator>
val c = for e <- it yield e * 2   // c: Iterator[Int] = <iterator>
```


===== Iterators are exhausted after using them

An iterator is exhausted (empty) after you use it ... if you use `foreach` to print an iterator’s elements, the call works the first time:

```scala
val it = Iterator(1,2,3)

it.foreach(print)   // 123
it.foreach(print)   // (no output here)
```


## An iterator behaves like a collection

An iterator defines many of the methods you’ll see in a normal collection class, including `foreach`, `map`, `filter`, etc.:

```scala
val i = Iterator(1,2,3)   // i: Iterator[Int] = <iterator>
val a = i.toVector        // a: Vector[Int] = Vector(1, 2, 3)

val i = Iterator(1,2,3)   // i: Iterator[Int] = <iterator>
val b = i.toList          // b: List[Int] = List(1, 2, 3)
```


## Iterators are lazy

Iterators are lazy, meaning that their transformer methods are evaluated in a non-strict, or lazy, manner ... notice that the following `for` loop, and the `map` and `filter` methods don’t return a concrete result, they simply return an iterator:

```scala
val i = Iterator(1,2,3)          // i: Iterator[Int] = <iterator>

val a = for e <- i yield e*2     // a: Iterator[Int] = <iterator>
val b = i.map(_ * 2)             // b: Iterator[Int] = <iterator>
val c = i.filter(_ > 2)          // c: Iterator[Int] = <iterator>
```

Like other lazy methods, they’re only evaluated when they’re forced to, such as by calling a *strict* method like `foreach`:

....
i.map(_ + 10).foreach(println)

11
12
13
....


## BufferedIterator lets you peak ahead

Create a `BufferedIterator` from an `Iterator` by calling its `buffered` method:

```scala
val it = Iterator(1,2)    // it: Iterator[Int] = <iterator>
val bi = it.buffered      // bi: BufferedIterator[Int] = <iterator>
```

After that, you can call the `head` method on the `BufferedIterator`, and it won’t affect the iterator:

```scala
// call 'head' as many times as desired
bi.head   // 1
bi.head   // 1
bi.head   // 1
```

Conversely, notice what happens when you call `next` on an `Iterator` or `BufferedIterator`:

```scala
// 'next' advances the iterator
bi.next   // 1
bi.next   // 2
bi.next   // java.util.NoSuchElementException: next on empty iterator
```


### Beware calling `head`

You’ll generally want to call `headOption` instead of `head`, because `head` can throw an exception:

```scala
// create a one-element BufferedIterator
val bi = Iterator(1).buffered
    // result: BufferedIterator[Int] = <iterator>

// 'head' works fine
bi.head         // 1

// advance the iterator
bi.next         // 1

// headOption works as intended
bi.headOption   // None

// but 'head' blows up
bi.head
    // result: java.util.NoSuchElementException: 
    //         next on empty iterator
```



