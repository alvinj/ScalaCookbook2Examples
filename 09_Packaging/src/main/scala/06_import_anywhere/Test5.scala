package test5

package foo {
  class Foo(a: Any)
}

@main def test5 =
  import foo.Foo
  println(Foo(1).getClass.getName) // test5.foo.Foo

// a few other examples ...
package bar {
  class Bar(b: Any)
}

package baz {
  class Baz(c: Any)
}

package orderentry {
  import foo.*
  // more code here ...
}

package customers {
  import bar.*
  // more code here ...

  package database {
    import baz.*
    // more code here ...
  }
}
