package com.leetcode.String

/**
  * Created by allianzcortex on 17-5-20.
  */
class Scala99 {

  // 第一道题，求最后一个元素
  def lastBuildin[A](l: List[A]): A = l match {
    // solution1  l(l.size-1)
    // solution2 l.last
    // solution3
    case h :: Nil => h
    case _ :: tail => lastBuildin(tail)
    case _ => throw new IllegalArgumentException("no")
  }

  // 第二道题
  def lastButOneElement[A](l: List[A]): A = l match {
    // 有一种解法是直接返回
    // if (l.isEmpty) throw new No...
    // else l.init.last
    case h :: _ :: Nil => h
    case _ :: tail => lastButOneElement(tail)
    case _ => throw new NoSuchElementException
  }

  // 第三道题，求第 k 个h _ ::一会需要重新做这道题
  // 这道题还是有问题，
  //  def nth[A](n: Int, l: List[A]): A = (n, l) match {
  //    // if(n>=0） l(n)
  //    // else throw new no...
  //    case (1, elem :: Nil) => elem
  //    case (_, tail :: _ :: Nil) => nth(n - 1, List(tail))
  //    case _ :: Nil => throw new IllegalArgumentException
  //
  //  }

  // 第四道题，求解长度
  def length[A](l: List[A]): Int = l match {
    case Nil => 0
    case _ :: tail => length(tail) + 1
    // 同样可以用 l.foldLeft(0) { (c, _) => c + 1 } 来求解
  }

  // 第五道题，逆转字符串
  def reverseList[A](l: List[A]): List[A] = l match {
    // 可以直接返回 l.reverse
    case Nil => l
    case head :: tail => reverseList(tail) ::: List(head)
  }

  // 第六道题，是否是回文字串
  def isPlaindromw[A](l: List[A]): Boolean = {
    // 可以直接用 l == l.reverse
    if (l.isEmpty) {
      println("--")
      return true // 为什么要用 return 来返回啊。。应该可以直接用 true 的
    }
    println(l)
    // 开始写的是 l(0)==l(l.size-1) 写的不好
    l.length == 1 || (l.head == l.last && isPlaindromw(l.slice(1, l.size - 1)))
  }

  // 第七道题，那 nested list 转平
  // 这里用泛型也可以吧？和用 any 区别？
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case elem => List(elem)
  }

  // 第八道题，去除重复元素
  def removeDuplicateElem(ls: List[Any]): List[Any] = ls match {
    // 可以这样用 ls.toSet.toList
    // 当然也可以这样ls.distinct
    // TODO 但为什么这条语句不对 ls.filter(x=>ls.count(x)==1)
    case Nil => Nil
    case head :: tail => head :: removeDuplicateElem(ls.dropWhile(_ == head))

  }

  // 第九道题 分类元素
  // 如果用 partition 是否会有更好的方法
  //  def pack(ls: List[Any]): List[List[Any]] = {
  //    if (ls.isEmpty)
  //      List(List())
  //    val unique = ls.distinct
  //    ls.partition(_ == 1)
  //  }

  // 第十题，计算 List 中元素与出现的次数
  def encode[A](ls: List[A]): List[(A, Int)] = {
    // 下面才是正确的定义方式，而非
    // scala.collection.mutable.Map[(A,Int)]
    val count = scala.collection.mutable.Map[A, Int]()
    for (elem <- ls.distinct) {
      count.put(elem, ls.count(_ == elem))
    }
    count.toList
  }

  // 第十一题 和第十题的意思类似
  def encodeModified[A](ls: List[A]): List[(A, Int)] = {
    val count = scala.collection.mutable.Map[A, Int]()
    for ((elem, index) <- ls.zipWithIndex) {
      if (index == 0)
        count.put(elem, 1)
      else {
        println(count)
        if (elem == count.last._1)
        // map 的 get 方法返回的是 Option[Int]，用 getOrElse 转化为 Int
          count.update(elem, count.getOrElse(elem, 0) + 1)
        else
        // 一个 Map 只能有 key，所以自己这里的逻辑不应该这么写，或者不应该用 Map 来做
        // TODO 功能没有实现
          count.put(elem, 1)

      }
    }
    count.toList
  }

  // 第十二题
  /*
    scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e
    这个问题自己实现的最后结果不是自己想要的
    TODO
   */
  def reArrangeList[A](ls: List[(Int, A)]): List[List[A]] = {
    // 关于 flatMap 和 case 这个问题，参考：http://stackoverflow.com/questions/22944468/using-tuples-in-map-flatmap-partial-functions
    ls.flatMap(tp =>
      for (index <- 1 to tp._1)
        yield List(tp._2)
    )
  }

  // 第十三题
  // 完全逆转，还是类似的思路，这道题就不做了
  def reverseReArrange(): Unit = {

  }

  // 第十四题，第十五题思路也是类似的
  // 为每个元素增加一个副本，思路很清晰啊
  def duplicate(ls: List[Any]): List[Any] = {
    ls.flatMap(elem => List(elem, elem))
  }

  // 第十六题
  def dropEveryNthElement[A](n: Int, ls: List[A]): List[A] = {
    // filter 只过滤满足要求的条件，如 List(1,2).filter(_==1) 得到的结果为 1
    // scala99 上还提供了用 case :: Nil 这种求解方法，但太复杂了，没必要看
    ls.zipWithIndex.filter(elem => (elem._2 + 1) % n != 0).map(_._1)
  }

  // 第十七题
  def splitToTwoPart[A](n: Int, ls: List[A]) = {
    // 下面这个是我的实现方式
    val s = ls.zipWithIndex.partition(elem => elem._2 + 1 <= n)
    (s._1.map(x => x._1), s._2.map(x => x._1))

    // 还有更好用的
    // 直接用 ls.splitAt(n) 后者 (ls.take(n),ls.drop(n))
  }

  // 第十八题，要求 Extract a slice from a list.
  // 直接用 ls.slice(start,end) 就可以了 [)
  // 非要用 case() 就是...


  // 第十九章 ... 后续一直

  // 下面开始 Arithmetic 章节部分
  // 第 31 部分
  def isPrime(num: Int): Boolean = {
    num > 1 && (2 to math.sqrt(num).toInt).toList.forall(x => num % x != 0)
    // 这个思路倒不难，但这里问题挺大的，有一个 inc
    /*
    scala> (1 to 3).toList
res19: List[Int] = List(1, 2, 3)

scala> List(1 to 3)
res20: List[scala.collection.immutable.Range.Inclusive] = List(Range(1, 2, 3))

后者不能用 forall 以及其他函数
还有 sqrt() 后是浮点数，要用 toInt 转为整形
     */

    // List(1, 2, 3).forall(x => x < 3)
  }

  // 第三十二道题
  // 嗯哼
  def gcd(x: Int, y: Int): Int = {
    if (y == 0) x
    else gcd(y, x % y)
  }

  // 第三十三题，完全没有意思啊，就是按照它的说明
  // coprime 就是两个数的最大公约数为 1

  // 接下来的 34 -41 都太偏数学了
  // 没有 42-45 部分

  // 第 46 部分 Logic and Codes

  // 第四十六题，太 tricky 了 48-50 基本也是同样道理


  // 之后的部分有的是 LeetCode，有的是太复杂了，各种泛型，就没有看的必要了
  // 来写一个二叉树


}

// 如果不用 abstract，在另一个新的 class 里建立同名类，会不会好点
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

  // 测试 TreeNode
  var root = new TreeNode(1)
  root.left = new TreeNode(2)
  root.right = new TreeNode(3)
  root.left.left = new TreeNode(4)

  // 计算 Depth

  def calDepth(root: TreeNode): Int = {
    if (root == null)
      return 0
    math.max(calDepth(root.left), calDepth(root.right)) + 1
  }

  println(calDepth(root))

  // 对 Scala 的整体理解已经可以了，接下来再多一点对类的处理就好了 case class ,object,trait ...

}