package com.chriswk.common

object MathHelpers {
  lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(i % _ > 0))
  lazy val fib: Stream[Int] = 0 #:: 1 #:: fib.zip(fib.tail).map(p => p._1 + p._2)
  def gcd(a: BigInt, b: BigInt): BigInt = if (b == 0) a else gcd(b, a%b)
  def lcm(a: BigInt, b: BigInt): BigInt = a*b / gcd(a,b)
  def even(a: Int) = a % 2 == 0
  def odd(a: Int) = a % 2 == 1
}
