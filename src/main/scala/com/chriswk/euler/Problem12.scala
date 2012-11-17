package com.chriswk.euler

/** *
  * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
  * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
  * Let us list the factors of the first seven triangle numbers:
  * 1: 1
  * 3: 1,3
  * 6: 1,2,3,6
  * 10: 1,2,5,10
  * 15: 1,3,5,15
  * 21: 1,3,7,21
  * 28: 1,2,4,7,14,28
  * We can see that 28 is the first triangle number to have over five divisors.
  * What is the value of the first triangle number to have over five hundred divisors?
  */
object Problem12 extends App {

  lazy val triangleNumbers: Stream[Int] = 0 #:: triangleNumbers.zipWithIndex.map(p => p._1 + p._2 + 1)
  def findDivisors (t: Int) = Range(1, Int.MaxValue).takeWhile(n => n * n <= t).foldLeft(0)((s, n) => if (t % n == 0) s + 2 else s)
  assert(findDivisors(28) == 6)
  val answer = triangleNumbers.find(findDivisors(_) > 500).get
  println(answer)
}