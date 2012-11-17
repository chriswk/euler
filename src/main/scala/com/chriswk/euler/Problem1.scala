package com.chriswk.euler

import com.chriswk.common.{MathHelpers, Profiling}

object Problem1 extends App {
  def sumOfNumbers(limit: Int, filters: List[Int]) = {
    (1 until limit).view.filter(n => filters.exists(p => n % p == 0))
  }
  def gaussianWay(limit: BigInt, filters: List[BigInt], priorInts: List[BigInt] = Nil): BigInt = {
    filters match {
      case Nil => 0
      case int::rest =>
        val n = limit / int // # of elements in series to sum
        int * ( n * (n+1) / 2) -
          gaussianWay(limit, priorInts.map(MathHelpers.lcm(int,_)).filter(_<=limit)) +
          gaussianWay(limit, rest, int::priorInts)
    }
  }

  Profiling.timed(Profiling.printTime("With view filter method (1000,3,5)")) {
    sumOfNumbers(1000, List(3, 5))
  }
  Profiling.timed(Profiling.printTime("With gaussian method (1000,3,5)")) {
    gaussianWay(1000, List(3, 5))
  }
  Profiling.timed(Profiling.printTime("With view filter method (1000000,3,5,11,13)")) {
    sumOfNumbers(1000000, List(3,5,11,13))
  }
  Profiling.timed(Profiling.printTime("With gaussian method (1000000,3,5,11,13)")) {
    gaussianWay(1000000, List(3,5,11,13))
  }

}
