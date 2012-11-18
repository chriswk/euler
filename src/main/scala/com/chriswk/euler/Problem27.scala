package com.chriswk.euler

import com.chriswk.common.MathHelpers.isPrime
/***
  * Euler published the remarkable quadratic formula:
  * n² + n + 41
  * It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
  * Using computers, the incredible formula  n²  79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, 79 and 1601, is 126479.
  * Considering quadratics of the form:
  * n² + an + b, where |a|  1000 and |b|  1000
  * where |n| is the modulus/absolute value of n
  * e.g. |11| = 11 and |4| = 4
  * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.*/
object Problem27 extends App {
  val values = (-999 until 1000).flatMap { a =>
    (-999 until 1000).map(b => (a, b, (0 to 1000).view.takeWhile(n => isPrime(n * n + a * n +b)).size))
  }
  val select = values.reduceLeft((a, b) => if (a._3 > b._3) a else b)
  val answer = select._1 * select._2
  println(answer)
}
