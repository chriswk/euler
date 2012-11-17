package com.chriswk.euler

object Problem15 extends App {

  def f(row: Seq[Long], c: Int): Long = {
    var s = 0L
    val next = row.map {
      n => s += n; s
    }
    if (c == 0) next.last else f(next, c - 1)
  }

  def answer(n: Int) = f(List.fill(n + 1)(1L), n - 1)

  println(answer(20))
}