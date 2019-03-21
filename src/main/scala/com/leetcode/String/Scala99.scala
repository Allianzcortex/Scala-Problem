package com.leetcode.String

/**
  * Created by allianzcortex on 17-5-20.
  */
class Scala99 {

  // Problem1 : find last item
  def lastBuildin[A](l: List[A]): A = l match {
    // solution1  l(l.size-1)
    // solution2 l.last
    // solution3
    case h :: Nil => h
    case _ :: tail => lastBuildin(tail)
    case _ => throw new IllegalArgumentException("no")
  }

  // Problem2
  def lastButOneElement[A](l: List[A]): A = l match {
    // 
    // if (l.isEmpty) throw new No...
    // else l.init.last
    case h :: _ :: Nil => h
    case _ :: tail => lastButOneElement(tail)
    case _ => throw new NoSuchElementException
  }

  // Problem3 : kth h value
  //  def nth[A](n: Int, l: List[A]): A = (n, l) match {
  //    // if(n>=0） l(n)
  //    // else throw new no...
  //    case (1, elem :: Nil) => elem
  //    case (_, tail :: _ :: Nil) => nth(n - 1, List(tail))
  //    case _ :: Nil => throw new IllegalArgumentException
  //
  //  }

  // Problem4 : find length
  def length[A](l: List[A]): Int = l match {
    case Nil => 0
    case _ :: tail => length(tail) + 1
    //  l.foldLeft(0) { (c, _) => c + 1 } is also available
  }

  // Problem 5 :reverse the string
  def reverseList[A](l: List[A]): List[A] = l match {
    // return l.reverse .... drectly
    case Nil => l
    case head :: tail => reverseList(tail) ::: List(head)
  }

  // Problem 6: aba=aba(reversed),while abc!=cba
  def isPlaindromw[A](l: List[A]): Boolean = {
    // return l == l.reverse
    if (l.isEmpty) {
      println("--")
      return true // 
    }
    println(l)
    // l(0)==l(l.size-1) is not a good practice
    l.length == 1 || (l.head == l.last && isPlaindromw(l.slice(1, l.size - 1)))
  }

  // Problem 7: nested list
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case elem => List(elem)
  }

  // Problem8: remove duplicate elementes
  def removeDuplicateElem(ls: List[Any]): List[Any] = ls match {
    // return ls.toSet.toList or ls.distinct
    case Nil => Nil
    case head :: tail => head :: removeDuplicateElem(ls.dropWhile(_ == head))

  }

  // Probelm9 : Classify
  //  def pack(ls: List[Any]): List[List[Any]] = {
  //    if (ls.isEmpty)
  //      List(List())
  //    val unique = ls.distinct
  //    ls.partition(_ == 1)
  //  }

  // Problem 10 : return appearence frequency
  def encode[A](ls: List[A]): List[(A, Int)] = {
    val count = scala.collection.mutable.Map[A, Int]()
    for (elem <- ls.distinct) {
      count.put(elem, ls.count(_ == elem))
    }
    count.toList
  }

  // Problem 11 : same like Problem 10
  def encodeModified[A](ls: List[A]): List[(A, Int)] = {
    val count = scala.collection.mutable.Map[A, Int]()
    for ((elem, index) <- ls.zipWithIndex) {
      if (index == 0)
        count.put(elem, 1)
      else {
        println(count)
        if (elem == count.last._1)
        // like `Optional` in Java 8 ,get() method in map will return Option[Int]
        // using getOrElse() to return int value
          count.update(elem, count.getOrElse(elem, 0) + 1)
        else
          count.put(elem, 1)

      }
    }
    count.toList
  }

  // Probelm 12 :
  /*
    scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e
   */
  def reArrangeList[A](ls: List[(Int, A)]): List[List[A]] = {
    // Issue about  flatMap and case ：
    // refer : http://stackoverflow.com/questions/22944468/using-tuples-in-map-flatmap-partial-functions
    ls.flatMap(tp =>
      for (index <- 1 to tp._1)
        yield List(tp._2)
    )
  }

  // Problem 13 : the same thought
  def reverseReArrange(): Unit = {

  }

 // Problem 14&15 : using default api 
  def duplicate(ls: List[Any]): List[Any] = {
    ls.flatMap(elem => List(elem, elem))
  }

  // Problem 16
  def dropEveryNthElement[A](n: Int, ls: List[A]): List[A] = {
    ls.zipWithIndex.filter(elem => (elem._2 + 1) % n != 0).map(_._1)
  }

  // Problem 17
  def splitToTwoPart[A](n: Int, ls: List[A]) = {
    val s = ls.zipWithIndex.partition(elem => elem._2 + 1 <= n)
    (s._1.map(x => x._1), s._2.map(x => x._1))

    // we can also use ls.splitAt(n) and (ls.take(n),ls.drop(n))
  }

  //  Arithmetic Part
  // Part 31
  def isPrime(num: Int): Boolean = {
    num > 1 && (2 to math.sqrt(num).toInt).toList.forall(x => num % x != 0)
    /*
    scala> (1 to 3).toList
    res19: List[Int] = List(1, 2, 3)

    scala> List(1 to 3)
    res20: List[scala.collection.immutable.Range.Inclusive] = List(Range(1, 2, 3))

    the result of sqrt() is float value, needed to be converted to int by toInt() method
     */

    // List(1, 2, 3).forall(x => x < 3)
  }

  // Probelm 32
  def gcd(x: Int, y: Int): Int = {
    if (y == 0) x
    else gcd(y, x % y)
  }

}

class TreeNode {
  var value: Int = 1
  var left: TreeNode = null
  var right: TreeNode = null

  def this(newvalue: Int) = {
    this()
    this.value = newvalue
  }

}


object testApp extends App {
  val s = new Scala99()
  val l = List(1, 2, 3, 4)
  println(s.lastBuildin(l))
  println(s.lastButOneElement(l))
  // TODO println(s.nth(3, l))
  println(s.length(l))
  println(s.reverseList(l))
  println(s.isPlaindromw(List(1, 2, 3, 3, 2, 1)))
  println(s.flatten(List(List(1, 2), 3, List(4, 5))))
  println(s.removeDuplicateElem(List(1, 1, 1, 2, 2, 3, 4)))
  // TODO println(s.pack(l))
  println(s.encode(List('A', 'B', 'A', 'B', 'C')))
  println(s.encodeModified(List('A', 'A', 'B', 'A', 'C')))
  println(s.reArrangeList(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
  println(s.duplicate(List('A', 'B', 'C')))
  println(s.dropEveryNthElement(2, List('A', 'B', 'C', 'D', 'E')))
  println(s.splitToTwoPart(3, List('A', 'B', 'C', 'D', 'E')))

  // Arithemetic
  println(s.isPrime(7))
  println(s.gcd(2, 6))

  // test TreeNode
  var root = new TreeNode(1)
  root.left = new TreeNode(2)
  root.right = new TreeNode(3)
  root.left.left = new TreeNode(4)

  // calculate Depth

  def calDepth(root: TreeNode): Int = {
    if (root == null)
      return 0
    math.max(calDepth(root.left), calDepth(root.right)) + 1
  }

  println(calDepth(root))

}