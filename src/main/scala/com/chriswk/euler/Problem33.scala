package com.chriswk.euler

import com.chriswk.common.MathHelpers.gcd

/** * The fraction 49/98 is a curious fraction, as an inexperienced
  * mathematician in attempting to simplify it may incorrectly believe that
  * 49/98 = 4/8, which is correct, is obtained by cancelling the 9s. We shall
  * consider fractions like, 30/50 = 3/5, to be trivial examples. There are
  * exactly four non-trivial examples of this type of fraction, less than one in
  * value, and containing two digits in the numerator and denominator. If the
  * product of these four fractions is given in its lowest common terms, find
  * the value of the denominator.
  */
object Problem33 extends App {
  val fractions = for {
    i <- 1 to 9
    j <- (i + 1) to 9
    k <- 1 to 9
    if k * (9 * i + j) == 10 * i * j
  } yield (10 * i + j, 10 * j + k)
  val commonProduct = fractions.reduceLeft((n, d) => (n._1 * d._1, n._2 * d._2))
  val answer = commonProduct._2 / gcd(commonProduct._1, commonProduct._2)
  println(fractions.mkString("\n"))
  println(commonProduct)
  println(answer)
}
