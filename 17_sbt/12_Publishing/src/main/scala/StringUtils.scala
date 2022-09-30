package com.alvinalexander.utils

/** This is a very small version of my Scala 3 StringUtils library on Github, which you can find here:
 *  https://github.com/alvinj/Scala3StringUtils
 */
object StringUtils:

  /** Returns a String that is the same as the input String, but truncated to the specified length.
   *  {{{
   *  val y = StringUtils.truncate("Alvin", 2)
   *  // result is "Al"
   *  }}}
   *  @param s
   *    The input string.
   *  @param length
   *    The maximum number of characters to return.
   */
  def truncate(s: String, length: Int) = s.take(length)

  /** A 'sanitize' method. Takes an input String, and returns a new String with all characters removed from that String
   *  other than letters and numbers.
   *  {{{
   *  val y = StringUtils.removeAllButLettersAndNumbers("`;|hack attempt!;`")
   *  // result is "hackattempt"
   *  }}}
   */
  def removeAllButLettersAndNumbers(s: String) =
    replaceAll(s, "[^a-zA-Z0-9]", "")

  /** @param s
   *    The string to perform the replace operation on (such as "123 Main Street")
   *  @param regex
   *    The regular expression to use to find what you want to replace.
   *  @param replaceWith
   *    The string you want to use as the replacement. Can be an empty string, asterisk, etc., anything you want to use
   *    as the replacement pattern.
   */
  def replaceAll(s: String, regex: String, replaceWith: String) =
    val r = regex.r
    r.replaceAllIn(s, replaceWith)
