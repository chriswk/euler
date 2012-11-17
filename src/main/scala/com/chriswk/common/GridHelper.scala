package com.chriswk.common

object GridHelper {
  def mkGrid(input: String) = {
    input.trim.split("\n").map(_.split("\\s+").map(_.toInt))
  }

  def sumOfGrid(rows: Array[Array[Int]], bottom: Seq[Int]): Int = {
    val ms = bottom.zip(bottom.tail).map(p => p._1 max p._2)
    val ss = rows.last.zip(ms).map(p => p._1 + p._2)
    if (ss.size == 1) ss.head else sumOfGrid(rows.init, ss)
  }

}
