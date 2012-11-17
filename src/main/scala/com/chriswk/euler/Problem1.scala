package com.chriswk.euler

import com.chriswk.common.MathHelpers._
import com.chriswk.common.Profiling._
/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Problem1 extends App {
  def sumOfNumbers(limit: Int, filters: List[Int]) = {
    (1 until limit).view.filter(n => filters.exists(p => n % p == 0)).sum
  }

  def gaussianWay(limit: BigInt, filters: List[BigInt], priorInts: List[BigInt] = Nil): BigInt = {
    filters match {
      case Nil => 0
      case head :: rest => {
        val n = limit / head // # of elements in series to sum
        head * (n * (n + 1) / 2) -
          gaussianWay(limit, priorInts.map(lcm(head, _)).filter(_ <= limit)) +
          gaussianWay(limit, rest, head :: priorInts)
      }
    }
  }

  val thousand = 1000
  timed(printTime("With view filter method (1000,3,5)")) {
    println(sumOfNumbers(thousand, List(3, 5)))
  }
  timed(printTime("With gaussian method (1000,3,5)")) {

    println(gaussianWay(thousand - 1, List(3, 5)))
  }
  timed(printTime("With gaussian method (10000000000000000000000000,3,5,7,9)")) {
    val tenZotta = BigInt("10000000000000000000000000")
    println(gaussianWay(tenZotta - 1, List(3,5,7,9)))
  }
}
