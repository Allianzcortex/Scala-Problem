name := "scala-learn"

version := "1.0"

scalaVersion := "2.12.2"



libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.1" % "test"
libraryDependencies += "junit" % "junit" % "4.8.1" % "test"

crossPaths := false

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test
testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")
libraryDependencies += "log4j" % "log4j" % "1.2.14"

