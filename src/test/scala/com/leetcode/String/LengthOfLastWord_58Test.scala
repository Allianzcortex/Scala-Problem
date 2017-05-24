package com.leetcode.String

import org.scalatest.{BeforeAndAfterEach, FunSuite}
import org.junit.Assert._

/**
  * Created by allianzcortex on 17-5-21.
  */
class LengthOfLastWord_58Test extends FunSuite with BeforeAndAfterEach {

  val solution: LengthOfLastWord_58 = new LengthOfLastWord_58()

  override def beforeEach() {

  }

  test("testLengthOfLastWord1") {
    assertEquals(solution.lengthOfLastWord1("abc def ghij"), 4)
    assertEquals(solution.lengthOfLastWord1("abc def  ghij   "), 4)
    assertEquals(solution.lengthOfLastWord1(""), 0)
    //assertEquals(solution.lengthOfLastWord1(" "), 0)
  }

  test("testLengthOfLastWord2") {
    assertEquals(solution.lengthOfLastWord2("abc def ghij"), 4)
    assertEquals(solution.lengthOfLastWord2("abc def  ghij   "), 4)
    assertEquals(solution.lengthOfLastWord2(""), 0)
    assertEquals(solution.lengthOfLastWord2(" "), 0)

  }

}
