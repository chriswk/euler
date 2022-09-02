package com.chriswk.euler

import com.chriswk.common.MathHelpers.primes

/** * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the sum of all
  * the primes below two million.
  */
object Problem10 extends App {
  def findSumOfPrimesBelow(n: Long) =
    primes.view.takeWhile(_ < n).foldLeft(0L)(_ + _)
  print(findSumOfPrimesBelow(2000000L))
}
