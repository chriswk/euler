package com.chriswk.euler

import com.chriswk.common.MathHelpers._

/** * In the following equation x, y and n are positive integers 1/x + 1/y = 1/n
  * It can be verified that when n = 1260 there are 113 distinct solutions and
  * this is the least value of n for which the total number of distinct
  * solutions exceeds one hundred. What is the least value of n for which the
  * number of distinct solutions exceeds four million? NOTE: This problem is a
  * much more difficult version of problem 108 and as it is well beyond the
  * limitations of a brute force approach it requires a clever implementation.
  */

object Problem110 extends App {
  def answer = find1OverXPlus1OverYEquals1OverN(4000000, primes.take(12), 2)
  println(answer)
}
