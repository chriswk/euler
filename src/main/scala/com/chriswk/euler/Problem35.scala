package com.chriswk.euler

import com.chriswk.common.MathHelpers._

/** * The number, 197, is called a circular prime because all rotations of the
  * digits: 197, 971, and 719, are themselves prime. There are thirteen such
  * primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97. How
  * many circular primes are there below one million?
  */

object Problem35 extends App {

  def circPrime(n: Int) =
    (0 to digits(n)).foldRight(true)((t, b) => (b && (isPrime(rotate(n, t)))))

  val answer = primes.takeWhile(_ < 1000000).filter(circPrime)
  println(answer.length)
}
