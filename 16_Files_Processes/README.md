# Chapter 16: Files and Processes

These are the source code examples for 
Chapter 16 of the [Second Edition of the Scala Cookbook](https://www.amazon.com/Scala-Cookbook-Object-Oriented-Functional-Programming-dp-1492051543/dp/1492051543).


## Examples in the introduction

These examples are shown in the introduction to Chapter 16:

```scala
import sys.process.*

val result: String = "ls -al".!!
val result = Seq("ls", "-al").!!
val rootProcs = ("ps aux" #| "grep root").!!.trim
val contents: LazyList[String] = sys.process.Process("find /Users -print").lazyLines
```


## Necessary files

A file named *foo.txt* should exist with this content:

```
foo
```

