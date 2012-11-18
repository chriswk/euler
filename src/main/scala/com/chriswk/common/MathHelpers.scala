package com.chriswk.common
import annotation.tailrec

object MathHelpers {
  lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i => primes.takeWhile(j => j * j <= i).forall(i % _ > 0))
  def isPrime(n: Int) = odd(n) && primes.view.takeWhile(_ <= n).contains(n)
  def primeFactors(num: Long): List[Long] = {
    val exists = (2L to math.sqrt(num).toLong).find(num % _ == 0)
    exists match {
      case Some(d) => d :: primeFactors(num / d)
      case None => List(num)
    }
  }
  lazy val fib: Stream[BigInt] = 0 #:: 1 #:: fib.zip(fib.tail).map(p => p._1 + p._2)
  def gcd(a: BigInt, b: BigInt): BigInt = if (b == 0) a else gcd(b, a%b)
  def lcm(a: BigInt, b: BigInt): BigInt = a*b / gcd(a,b)
  def even(a: BigInt) = a % 2 == 0
  def odd(a: BigInt) = a % 2 == 1
  def square(a: Int) = a * a
  def sumOfSquares(start: Int, finish: Int): BigInt = (start to finish).map(square).sum
  def squareOfSum(start: Int, finish: Int): BigInt = square((start to finish).sum)
  def fac(n: Int) = {
    @tailrec
    def factorial(n: Int, accu: BigInt): BigInt = {
      if(n == 0) accu
      else {
        factorial(n-1, n * accu)
      }
    }
    factorial(n, 1)
  }
  def sumOfNumberAsString(n: BigInt) = n.toString.view.map(_.asDigit).sum
  def sumOfDivisors(finish: Int) = (0 until finish).view.map(n => (1 to (n/2)).filter(n % _ == 0).sum)
  def eagerSumOfDivisors(finish: Int) = (0 until finish).map(n => (1 to (n/2)).filter(n % _ == 0).sum)
  def permutationOfString(s: String): Seq[String] = if (s.size == 1) Seq(s) else s.flatMap(c => permutationOfString(s.filterNot(_ == c)).map(c +))
  def find1OverXPlus1OverYEquals1OverN(solutionTop: Int, base: Seq[Int], m: Int): Long = {
    val s = base ++ primeFactors(m)
    val solutions = (s ++ s).groupBy(x => x).map(_._2.size).map(_+1).product/2+1
    if (solutions > solutionTop) base.map(_.toLong).product * m
    else find1OverXPlus1OverYEquals1OverN(solutionTop, base, m+1)
  }
  def sumOfPowersOfDigits(n: Int, power: Int) = n.toString.map(_.asDigit).map(math.pow(_, power).toInt).sum
}
