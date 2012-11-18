package com.chriswk.euler

import com.chriswk.common.MathHelpers.{primes, isPrime}
object Problem37 extends App {

  def isLPrime(prime: String): Boolean = if(prime == "") true else isPrime(prime.toInt) && isLPrime(prime.substring(1))
  def isRPrime(prime: Int): Boolean = (prime == 0) || (isPrime(prime) && isRPrime(prime/10))
  def isTruncablePrime(prime: Int) = isRPrime(prime) && isLPrime(prime.toString)

  def answer = primes.dropWhile(_ < 10).takeWhile(_ < 1000000).filter(isTruncablePrime)
  println(answer.sum)
}
