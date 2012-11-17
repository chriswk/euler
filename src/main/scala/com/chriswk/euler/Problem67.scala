package com.chriswk.euler

import com.chriswk.common.GridHelper._
import com.chriswk.common.Profiling

/** *
  * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
  * 3
  * 7 4
  * 2 4 6
  * 8 5 9 3
  * That is, 3 + 7 + 4 + 9 = 23.
  * Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.
  * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 2.pow(99) altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
  */
object Problem67 extends App {
  val prob67 = Profiling.timed(Profiling.printTime("Made grid from file in ")) { mkGrid(scala.io.Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("triangle.txt")).mkString) }
  val ans67 = Profiling.timed(Profiling.printTime("Found sum of grid")) { sumOfGrid(prob67.init, prob67.last) }
  println(ans67)
}