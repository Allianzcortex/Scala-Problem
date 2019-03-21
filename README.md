
#### Leetcode Solution With Scala [![Build Status](https://travis-ci.org/Infra-Intern/Scala-Problem.svg?branch=master)](https://travis-ci.org/Infra-Intern/Scala-Problem)

| ID | Problem  | Solution | TestCase |
| -- | ------------- | ------------- | ------------- |
| 58 | [length-of-last-word](https://leetcode.com/problems/length-of-last-word/)  | [Solution](src/main/scala/com/leetcode/String/LengthOfLastWord_58.scala)  | [TestCase](/src/test/scala/com/leetcode/String/LengthOfLastWord_58Test.scala) |
| 345 | [reverse-vowels-of-a-string](https://leetcode.com/problems/reverse-vowels-of-a-string/description/)  | [Solution](src/main/scala/com/leetcode/String/ReverseVowelsOfAString_345.scala)  | [TestCase](/src/test/scala/com/leetcode/String/ReverseVowelsOfAString_345Test.scala) |

Scala99:  [Solution](src/main/scala/com/leetcode/String/Scala99.scala)

#### Integrate Scala-test and Junit in Scala

When writing this application ,I found that it is 
available to run test cases in local `Intellij IDEA+Junit` ,but if you try to execute the command `sbt test` , the tests will fail and the results are `no tests are executed`.

The solution is to add `testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")` in `build.sbt` file , you can check my [blog post](http://allianzcortex.me/2017/05/21/Scala-Test-Junit-Sbt-Problem/) for more details.

#### Current Status

This project is temporarily deprecated. Because:

* I have transferred my focus from `Big Data` to other areas. Even there are development requirements, `Java/Pyspark` will be enough.

* Many Online Judge websites have began to support scala officially with more adequate test data.

But one day this repo may reopen T^T.



