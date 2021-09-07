# Recipe 14.3, Adding, Updating, and Removing Immutable Map Elements


Start with this `Map`:

[source,scala]
----
val a = Map(1 -> "a")    // a: Map[Int, String] = Map(1 -> a)
----


## Adding elements

Add one key/value pair with the `+` method:

[source,scala]
----
// add one element
val b = a + (2 -> "b")   // b: Map(1 -> a, 2 -> b)
----

Add two or more key/value pairs using `++` and a collection:

[source,scala]
----
// add multiple elements
val c = b ++ Map(3 -> "c", 4 -> "d")
    // c: Map(1 -> a, 2 -> b, 3 -> c, 4 -> d)

val d = c ++ List(5 -> "e", 6 -> "f")
    // d: HashMap(5 -> e, 1 -> a, 6 -> f, 2 -> b, 3 -> c, 4 -> d)
----


## Updating elements

Update one key/value pair with an immutable map:

[source,scala]
----
val e = d + (1 -> "AA")
    // e: HashMap(5 -> e, 1 -> AA, 6 -> f, 2 -> b, 3 -> c, 4 -> d)
----

Update multiple key/value pairs:

[source,scala]
----
// update multiple elements at once with a Map
val e = d ++ Map(2 -> "BB", 3 -> "CC")
    // e: HashMap(5 -> e, 1 -> a, 6 -> f, 2 -> BB, 3 -> CC, 4 -> d)

// update multiple elements at once with a List
val e = d ++ List(2 -> "BB", 3 -> "CC")
    // e: HashMap(5 -> e, 1 -> a, 6 -> f, 2 -> BB, 3 -> CC, 4 -> d)
----



## Removing elements

To remove one element use the `-` method:

[source,scala]
----
val e = d - 1   // e: HashMap(5 -> e, 6 -> f, 2 -> b, 3 -> c, 4 -> d)
----

To remove multiple elements use the `--` method:

[source,scala]
----
val e = d -- List(1, 2, 3)   // e: HashMap(5 -> e, 6 -> f, 4 -> d)
----


## Discussion

Using a `var`, the previous examples look like this:

[source,scala]
----
// declare the map variable as a `var`
var a = Map(1 -> "a")

// add one element
a = a + (2 -> "b")

// add multiple elements
a = a ++ Map(3 -> "c", 4 -> "d")
a = a ++ List(5 -> "e", 6 -> "f")

// update where the key is 1
a = a + (1 -> "AA")

// update multiple elements at one time
a = a ++ Map(2 -> "BB", 3 -> "CC")
a = a ++ List(4 -> "DD", 5 -> "EE")

// remove one element by specifying its key
a = a - 1

// remove multiple elements
a = a -- List(2, 3)
----

In these examples, because `a` is defined as a `var`, it’s being reassigned during each step in the process.




