package com.leetcode.String

/**
  * Created by allianzcortex on 17-5-24.
  */
class ReverseVowelsOfAString_345 {

  // TODO 这里怎么用 Scala 的方式来解决，感觉很难做到
  def reverseVowels1(input: String): String = {
    if (input == null || input.isEmpty)
      input
    else {
      import scala.util.control.Breaks._
      val vowel_list = "aeiouAEIOU"
      val arr = input.toCharArray

      var begin = 0
      var end = arr.length - 1
      while (begin <= end) {
        while (begin <= end && !vowel_list.contains(arr(begin)))
          begin += 1
        while (begin <= end && !vowel_list.contains(arr(end)))
          end -= 1
        if (begin <= end) {
          var temp = arr(begin)
          arr(begin) = arr(end)
          arr(end) = temp
        }
        begin += 1
        end -= 1
      }
      arr.mkString("")
    }
  }
}

object main extends App {
  val solution = new ReverseVowelsOfAString_345()
  println(solution.reverseVowels1("hello"))
}
