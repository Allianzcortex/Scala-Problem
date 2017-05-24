package com.leetcode.util

import org.junit.Assert._
import org.scalatest.junit.{AssertionsForJUnit}
import com.leetcode.util.{FileUtil => xx}
import org.junit.Test

/**
  * Created by allianzcortex on 17-5-19.
  */
class FileUtilTest extends  AssertionsForJUnit {



  @Test def test_max()={
    assertTrue(xx.max(1,2)==2)
  }

}
