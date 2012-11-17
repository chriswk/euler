package com.chriswk.euler

import com.chriswk.common.MathHelpers.lcm
/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Problem5 extends App {
  val ans = (1 to 20).foldLeft(BigInt(1))((a,b) => lcm(a,b))
  println(ans)
}
