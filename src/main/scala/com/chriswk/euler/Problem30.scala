package com.chriswk.euler

/** *
  * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
  */
import com.chriswk.common.MathHelpers.sumOfPowersOfDigits
object Problem30 extends App {
  def max(d: Int) = math.pow(10, d).toInt - 1
  val limit = Stream.from(1).find(d => max(d) > sumOfPowersOfDigits(max(d), 5)).get
  val answer = (2 to max(limit)).view.filter(n => n == sumOfPowersOfDigits(n, 5)).sum
  println(answer)
}
