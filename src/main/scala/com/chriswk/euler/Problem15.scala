package com.chriswk.euler

import com.chriswk.common.Profiling

/** Starting in the top left corner of a 22 grid, there are 6 routes (without
  * backtracking) to the bottom right corner. How many routes are there through
  * a 2020 grid?
  */
object Problem15 extends App {

  def f(row: Seq[Long], c: Int): Long = {
    var s = 0L
    val next = row.map { n =>
      s += n; s
    }
    if (c == 0) next.last else f(next, c - 1)
  }

  def answer(n: Int) = Profiling.timed(
    Profiling.printTime("Found routes for " + n + "x" + n + " grid")
  ) { f(List.fill(n + 1)(1L), n - 1) }
  assert(answer(2) == 6)
  println(answer(20))
}
