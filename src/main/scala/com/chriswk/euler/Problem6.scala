package com.chriswk.euler
import com.chriswk.common.MathHelpers.sumOfSquares
import com.chriswk.common.MathHelpers.squareOfSum
/***
  * The sum of the squares of the first ten natural numbers is,
  * 12 + 22 + ... + 102 = 385
  * The square of the sum of the first ten natural numbers is,
  * (1 + 2 + ... + 10)2 = 552 = 3025
  * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
  * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum*/
object Problem6 extends App {
  def diff(start: Int, finish: Int) = {
    squareOfSum(start, finish) - sumOfSquares(start, finish)
  }
  assert(diff(1, 10) == 2640)
  val answer = diff(1, 100)
  println(answer)
}
