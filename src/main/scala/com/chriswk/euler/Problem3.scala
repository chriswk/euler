package com.chriswk.euler

import com.chriswk.common.MathHelpers.primes

/** * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime
  * factor of the number 600851475143 ?*
  */

object Problem3 extends App {

  val goal = 600851475143L
  val limit = scala.math.sqrt(goal)
  val answer = primes.view.takeWhile(_ < limit).filter(goal % _ == 0).last
  println(answer)
}
