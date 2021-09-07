# Recipe 15.7, Creating and Using a Queue


A `Queue` is a FIFO data structure. Create an empty, mutable queue:

```scala
import scala.collection.mutable.Queue

val q = Queue[Int]()
val q = Queue[String]()
```

Create a queue with initial elements:

```scala
val q = Queue(1, 2, 3)         // q: Queue[Int] = Queue(1, 2, 3)
```

Add elements using `+=`, `++=`, `enqueue`, and `enqueueAll`:

```scala
import scala.collection.mutable.Queue

val q = new Queue[String]      // q: collection.mutable.Queue[String] = Queue()

// add elements to the queue
q += "a"                       // q: Queue(a)
q ++= List("b", "c")           // q: Queue(a, b, c)
q.enqueue("d")                 // q: Queue(a, b, c, d)
q.enqueue("e", "f")            // q: Queue(a, b, c, d, e, f)
q.enqueueAll(List("g", "h"))   // q: Queue(a, b, c, d, e, f, g, h)
```

New elements are added to the end of the queue.

Remove elements from the head using `dequeue`:

```scala
import scala.collection.mutable.Queue
val q = Queue(1, 2, 3)   // q: mutable.Queue[Int] = Queue(1, 2, 3)

// take an element from the head of the queue
val next = q.dequeue     // next=1, q=Queue(2, 3)
val next = q.dequeue     // next=2, q=Queue(3)
val next = q.dequeue     // next=3, q=Queue()

// `q` is now empty; beware calling dequeue on an empty Queue:
val next = q.dequeue
    // result: java.util.NoSuchElementException: empty collection
```

Can also use the `dequeueFirst` and `dequeueAll`:

```scala
import scala.collection.mutable.Queue
val q = Queue(1,2,3,4,5)          // q: Queue(1, 2, 3, 4, 5)

// found the number 3, so remove it from the queue
val res = q.dequeueFirst(_ > 2)   // res=Some(3),       q=Queue(1, 2, 4, 5)

// no matches
val res = q.dequeueFirst(_ > 5)   // res=None,          q=Queue(1, 2, 4, 5)

// match three elements, remove them from the queue
val res = q.dequeueAll(_ > 1)     // res=List(2, 4, 5), q=Queue(1)

// no matches
val res = q.dequeueAll(_ > 1)     // res=List(),        q=Queue(1)
```


## Discussion

Like other collections clases, `Queue` has dozens of other methods, including these:

```scala
import scala.collection.mutable.Queue
val q = Queue(1,2,3,4,5)

q.size            // 5
q.isEmpty         // false
q.count(_ > 3)    // 2
q.filter(_ > 3)   // Queue(4, 5)
```



## Immutable queues

With the immutable `Queue` class, you generally add elements with `enqueue` and `enqueueAll`, and remove elements with `dequeue`:

```scala
import scala.collection.immutable.Queue

val q1 = Queue[Int]()               // q1: Queue[Int] = Queue()
val q2 = q1.enqueue(1)              // q2: Queue(1)
val q3 = q2.enqueueAll(List(2,3))   // q3: Queue(1, 2, 3)

val (a, q4) = q3.dequeue            // a=1, q4=Queue(2, 3)
val (b, q5) = q4.dequeue            // b=2, q5=Queue(3)
val (c, q6) = q5.dequeue            // c=3, q6=Queue()

// `q6` is now empty; beware calling dequeue on an empty queue:
val (d, q7) = q6.dequeue
    // result: java.util.NoSuchElementException: dequeue on empty queue
```




