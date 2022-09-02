package com.chriswk.euler

/** * A Pythagorean triplet is a set of three natural numbers, a b c, for which,
  * a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52. There exists exactly
  * one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
  */
object Problem9 extends App {
  def isTriplet(a: Int, b: Int, c: Int, sum: Int): Boolean =
    (a * a) + (b * b) == (c * c) && a + b + c == sum && a < b && b < c

  def tripletForSum(sum: Int) = {
    val triplets = for {
      a <- (1 to sum).view
      b <- 1 to sum - a
      c <- 1 to sum - a - b
      if (isTriplet(a, b, c, sum))
    } yield (a, b, c)
    triplets.head
  }
  val answerTriplet = tripletForSum(1000)
  val answer = answerTriplet._1 * answerTriplet._2 * answerTriplet._3
  println(answer)
}
