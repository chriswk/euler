package com.chriswk.euler

/** *
  * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
  * 21 22 23 24 25
  * 20  7  8  9 10
  * 19  6  1  2 11
  * 18  5  4  3 12
  * 17 16 15 14 13
  * It can be verified that the sum of the numbers on the diagonals is 101.
  * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
  */
object Problem28 extends App {
  def circle(centerValue: Int, currentRadii: Int): Stream[Int] = (centerValue * 4 + currentRadii * 10) #:: circle(centerValue + currentRadii * 4, currentRadii + 2)
  println(1 + circle(1,2).take(2).sum)
  val answer = 1 + circle(1, 2).take(500).sum
  println(answer)
}
