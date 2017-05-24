![build-pass](https://travis-ci.org/Allianzcortex/Scala-LeetCode.svg?branch=master)

Scala of LeetCode

- scala-test 和 junit 集成：

- 单纯用 Intellij IDEA 是可以跑测试用例的，但用 `sbt test` 的话会提** no tests are executed**

- 解决方法是在 build.sbt 后面加 `testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")`




