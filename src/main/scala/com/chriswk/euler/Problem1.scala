package com.chriswk.euler

import com.chriswk.common.{MathHelpers, Profiling}

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
          gaussianWay(limit, priorInts.map(MathHelpers.lcm(head, _)).filter(_ <= limit)) +
          gaussianWay(limit, rest, head :: priorInts)
      }
    }
  }

  val thousand = 1000
  Profiling.timed(Profiling.printTime("With view filter method (1000,3,5)")) {
    println(sumOfNumbers(thousand, List(3, 5)))
  }
  Profiling.timed(Profiling.printTime("With gaussian method (1000,3,5)")) {

    println(gaussianWay(thousand - 1, List(3, 5)))
  }
  Profiling.timed(Profiling.printTime("With gaussian method (1000000,3,5,11,13)")) {
    val tenZotta = BigInt("10000000000000000000000000")
    println(gaussianWay(tenZotta - 1, List(3,5,7,9)))
  }
}
