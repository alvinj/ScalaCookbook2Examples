package r07_exception_annotations

// p. 661
object SExceptionThrower:
  @throws(classOf[Exception])
  def exceptionThrower = throw new Exception("Exception from Scala!")
