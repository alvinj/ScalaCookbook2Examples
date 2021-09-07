# Recipe 14.5, Accessing Map Values (Without Exceptions)

Given a map:

```scala
val states = Map(
    "AL" -> "Alabama",
    "AK" -> "Alaska",
    "AZ" -> "Arizona"
)
```

`withDefaultValue`:

```scala
val states = Map(
    "AL" -> "Alabama"
).withDefaultValue("Not found")
```

Creates a default value that’s used when a key isn’t found:

```scala
val x = states("AL")   // x: Alabama
val x = states("yo")   // x: Not found
```

Use `getOrElse`:

```scala
val s = states.getOrElse("yo", "No such state")   // s: No such state
```

Use `get`, which returns an `Option`:

```scala
val x = states.get("AZ")   // x: Some(Arizona)
val x = states.get("yo")   // x: None
```





