
#### Leetcode Solution With Scala [![Build Status](https://travis-ci.org/Infra-Intern/Scala-Problem.svg?branch=master)](https://travis-ci.org/Infra-Intern/Scala-Problem)

| ID | Problem  | Solution | TestCase |
| -- | ------------- | ------------- | ------------- |
| 58 | [length-of-last-word](https://leetcode.com/problems/length-of-last-word/)  | [Solution](src/main/scala/com/leetcode/String/LengthOfLastWord_58.scala)  | [TestCase](/src/test/scala/com/leetcode/String/LengthOfLastWord_58Test.scala) |
| 345 | [reverse-vowels-of-a-string](https://leetcode.com/problems/reverse-vowels-of-a-string/description/)  | [Solution](src/main/scala/com/leetcode/String/ReverseVowelsOfAString_345.scala)  | [TestCase](/src/test/scala/com/leetcode/String/ReverseVowelsOfAString_345Test.scala) |

Scala99:[Solution](src/main/scala/com/leetcode/String/Scala99.scala)

#### Integrate Scala-test and Junit in Scala

After I develop

- 单纯用 Intellij IDEA + JUnit 可以在本地 IDEA 上跑测试用例，但用 `sbt test` 命令行测试的话会提 **no tests are executed**

- 解决方法是在 build.sbt 后面加 `testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")` 具体原因参考：[Scala-Junit-Integration](http://allianzcortex.me/2017/05/21/Scala-Test-Junit-Sbt-Problem/)

#### Current Status

This project is temporarily deprecated. Because:

1. I have transfered my focus from `Big Data` to other areas. In other words, Even there are development requirements, `Java/Pyspark` will be enough.

2. Leetcode has began to support scala officialy with more adequate test data.

But maybe this project will reopen one day.thx for your support.




