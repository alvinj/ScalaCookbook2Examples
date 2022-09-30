package r06_method_parentheses

class Pizza:
  // no parentheses after 'crustSize'
  def crustSize = 12

@main def methodParens =
  val p = Pizza()
  // p.crustSize()   // won’t compile
  p.crustSize // does compile
