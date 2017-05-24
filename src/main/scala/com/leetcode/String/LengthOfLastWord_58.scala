package com.leetcode.String

import com.leetcode.util.Logs

/**
  * @author allianzcortex
  */
class LengthOfLastWord_58 extends Logs {

  def lengthOfLastWord1(input: String): Int = {
    input.split("\\s+").last.length
  }

  def lengthOfLastWord2(input: String): Int = {
    if (input.trim.isEmpty)
      0
    // if don't add else,you will need to use return 0 instead 0
    // refer to :http://stackoverflow.com/questions/12560463/return-in-scala
    else {
      var first, last = input.length - 1
      while (input.charAt(last) == ' ') {
        last -= 1
      }
      first = last

      while (input.charAt(first) != ' ') {
        first -= 1
      }
      info("final answer is " + (last - first))
      last - first
    }
  }

}

/**
  * Just For Debug
  */
object LengthOfLastWord_58 extends App {
  val s: LengthOfLastWord_58 = new LengthOfLastWord_58()
  println(s.lengthOfLastWord2("ab de f"))

}
