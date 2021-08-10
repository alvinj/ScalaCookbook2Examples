package r00_intro

val hello = "Hello, world"

@main def intro = 
    val s = "foo bar baz"
    assert(s.count(_ == 'a')     == 2)
    assert(s.dropRight(2)        == "foo bar b")
    assert(s.dropWhile(_ != 'b') == "bar baz")
    assert(s.filter(_ != 'o')    == "f bar baz")
    assert(s.sortWith(_ < _)     == "  aabbfoorz")
    assert(s.take(3)             == "foo")
    assert(s.takeRight(3)        == "baz")
    assert(s.takeWhile(_ != 'r') == "foo ba")

