package com.chriswk.common

object MathHelpers {
  lazy val primes: Stream[Int] = Profiling.timed(Profiling.printTime("Calculated primes in ")) {
    2 #:: primes.map(i => Stream.from(i + 1).find(j => primes.takeWhile(k => k * k <= j).forall(j % _ > 0)).get)
  }
  def gcd(a: BigInt, b: BigInt): BigInt = if (b == 0) a else gcd(b, a%b)
  def lcm(a: BigInt, b: BigInt): BigInt = a*b / gcd(a,b)

}
