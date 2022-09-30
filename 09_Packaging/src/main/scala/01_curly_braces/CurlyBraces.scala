package r01

// The first example in the Solution.
package com.acme.store {
  class Foo:
    override def toString = "I am com.acme.store.Foo"
}

// The second example in the Solution.
package orderentry {
  class Foo:
    override def toString = "I am orderentry.Foo"
}

package customers {
  class Foo:
    override def toString = "I am customers.Foo"

  package database {
    class Foo:
      override def toString = "I am customers.database.Foo"
  }
}

// Test/demonstrate the Foo classes.
// The output is shown after the comment tags.
// TODO replace these with tests.
@main def curlyBraceTests =
  println(orderentry.Foo())         // I am orderentry.Foo
  println(customers.Foo())          // I am customers.Foo
  println(customers.database.Foo()) // I am customers.database.Foo
