package com.chriswk.euler

import com.chriswk.common.MathHelpers


object Problem10 extends App {


  def findSumOfPrimesBelow(n: Long) = {
	  MathHelpers.primes.view.takeWhile(_ < n).foldLeft(0L)(_ + _)
  }

  print(findSumOfPrimesBelow(2000000L))
}