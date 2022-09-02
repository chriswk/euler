package com.chriswk.euler
import com.chriswk.common.Profiling._
import com.chriswk.common.MathHelpers.{fac, sumOfNumberAsString}
/*
 * n! means n  (n  1)  ...  3  2  1
 * For example, 10! = 10  9  ...  3  2  1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 */

object Problem20 extends App {
  val answer = timed(printTime("Found sum of numbers in fac(100) in ")) {
    sumOfNumberAsString(fac(100))
  }
  val answer1k = timed(printTime("Found sum of numbers in fac(1000) in ")) {
    sumOfNumberAsString(fac(1000))
  }
  println(answer1k)
  println(answer)
}
