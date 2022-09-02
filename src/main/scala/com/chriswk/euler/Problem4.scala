package com.chriswk.euler

import math.Integral.Implicits.infixIntegralOps

/** * A palindromic number reads the same both ways. The largest palindrome made
  * from the product of two 2-digit numbers is 9009 = 91 99. Find the largest
  * palindrome made from the product of two 3-digit numbers.
  */
object Problem4 extends App {
  val answer = (100 to 999).view
    .flatMap(i => (i to 999).map(x => i * x))
    .filter(n => n.toString == n.toString.reverse)
    .max
  println(answer)

}
