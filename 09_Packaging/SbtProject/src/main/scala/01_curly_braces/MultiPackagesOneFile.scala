package r01_curly_braces

// I don’t think this example is in the Scala Cookbook,
// but it shows how to have multiple packages in one
// file without using curly braces. I use curly braces
// in almost every example here because I think they
// make the longer examples easier to grok, but this
// approach is perfectly valid, and very clean.

package com.acme.foo:
    class Foo:
        override def toString = "Foo"

package com.acme.bar:
    import com.acme.foo.Foo
    class Bar:
        val foo = Foo()

package com.acme.common:
    import com.acme.bar.Bar
    @main def multiPackageTest =
        val b = Bar()
        println(b.getClass)   // r01_curly_braces.com.acme.bar.Bar
        println(b.foo)
