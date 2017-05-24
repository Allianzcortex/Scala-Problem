package com.leetcode.String

import org.scalatest.{BeforeAndAfterEach, FunSuite}

import com.leetcode.String.ReverseVowelsOfAString_345

/**
  * Created by allianzcortex on 17-5-24.
  */
class ReverseVowelsOfAString_345Test extends FunSuite with BeforeAndAfterEach {

  private var solution: ReverseVowelsOfAString_345 = _

  override def beforeEach() {
    solution = new ReverseVowelsOfAString_345()
  }

  test("testReverseVowels1") {
    assert(solution.reverseVowels1(null) == null)
    assert(solution.reverseVowels1("") == "")
    assert(solution.reverseVowels1("hello") == "holle")
  }

}
