package com.chriswk.euler
import com.chriswk.common.MathHelpers.fac
/*
* 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
* Find the sum of all numbers which are equal to the sum of the factorial of their digits.
* Note: as 1! = 1 and 2! = 2 are not sums they are not included.
* */
object Problem34 extends App {
  def digFact(sum: BigInt, n: BigInt): BigInt = {
    if (n == 0) sum else digFact(fac(n.toInt % 10) + sum, n/10)
  }

  def check(sum: Int, n: Int):Int = {
    if (n > 7*fac(9)) sum
    else if (digFact(0, n) == n) check(sum+n, n+1)
    else check(sum, n+1)
  }
  val answer = check(0, 10)
  println(answer)
}
