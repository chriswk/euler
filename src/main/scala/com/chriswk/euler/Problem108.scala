package com.chriswk.euler

import com.chriswk.common.MathHelpers._
/***
  * In the following equation x, y and n are positive integers 1/x + 1/y = 1/n
  * For n = 4 there are exactly three distinct solutions 1/5 + 1/20 = 1/4 ...
  * Find the least value of n for which the number of distinct solutions exceeds one thousand
  */
object Problem108 extends App {

  def answer = find1OverXPlus1OverYEquals1OverN(1000, primes.take(6), 2)
  println(answer)
}
