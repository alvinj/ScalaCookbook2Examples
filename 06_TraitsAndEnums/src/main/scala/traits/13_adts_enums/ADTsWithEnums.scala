package r13_adts_enums

// p. 214
enum Bool:
  case True, False

import Bool.*

def and(a: Bool, b: Bool): Bool = (a, b) match
  case (True, True)   => True
  case (False, False) => False
  case (True, False)  => False
  case (False, True)  => False

def or(a: Bool, b: Bool): Bool = (a, b) match
  case (True, _) => True
  case (_, True) => True
  case (_, _)    => False

@main def testBool =
  println(and(True, True) == True)
  println(and(True, False) == False)
  println(or(True, False) == True)
  println(or(False, False) == False)
