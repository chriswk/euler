package com.chriswk.common

object MathHelpers {
  lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(i % _ > 0))
  def primeFactors(num: Long): List[Long] = {
    val exists = (2L to math.sqrt(num).toLong).find(num % _ == 0)
    exists match {
      case Some(d) => d :: primeFactors(num / d)
      case None => List(num)
    }
  }
  lazy val fib: Stream[Int] = 0 #:: 1 #:: fib.zip(fib.tail).map(p => p._1 + p._2)
  def gcd(a: BigInt, b: BigInt): BigInt = if (b == 0) a else gcd(b, a%b)
  def lcm(a: BigInt, b: BigInt): BigInt = a*b / gcd(a,b)
  def even(a: Int) = a % 2 == 0
  def odd(a: Int) = a % 2 == 1
  def square(a: Int) = a * a
  def sumOfSquares(start: Int, finish: Int): BigInt = (start to finish).map(square).sum
  def squareOfSum(start: Int, finish: Int): BigInt = square((start to finish).sum)

}
