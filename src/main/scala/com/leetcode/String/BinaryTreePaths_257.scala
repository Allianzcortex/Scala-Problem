package com.leetcode.String

import java.io.{FileNotFoundException, IOError}

import com.leetcode.util.FileUtil

/**
  * Created by allianzcortex on 17-5-19.
  * Given a binary tree, return all root-to-leaf paths.
  * For example, given the following binary tree:
  * 1
  * / \
  * 2 3
  * \
  * 5
  * All root-to-leaf paths are:
  * [“1->2->5”, “1->3”]
  */
class BinaryTreePaths_257 {

  def test(): Unit = {
    val one = List(1, 2)
    val pair = (1, "some")
    println(pair._1)
    println(pair._2)

    val testMap = Map(1 -> "a", 2 -> "b")
    println(testMap.keys)
    println(testMap(1)) // a

    // process string
    val s = "Hello World"
    println(s.indexOf("H")) // 0

    for(i<- 1 to 2;j<- 2 to 3){
      println(s"i is $i,j is $j")
    }

  }

  def readTextFile(filename: String): Option[List[String]] = {
    try {
      Some(io.Source.fromFile(filename).getLines().toList)
    } catch {
      case ioe: IOError => None
      case fof: FileNotFoundException => None
      //  case _: => None
    }
  }

  override def toString: String = "New Class"

}

object BinaryTreePaths_257 {

  def main(args: Array[String]): Unit = {
    val obj = new BinaryTreePaths_257()
    obj.test()
  }
}
