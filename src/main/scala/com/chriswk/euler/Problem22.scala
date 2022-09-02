package com.chriswk.euler

import com.chriswk.common.FileHelper

/** * Using names.txt (right click and 'Save Link/Target As...'), a 46K text
  * file containing over five-thousand first names, begin by sorting it into
  * alphabetical order. Then working out the alphabetical value for each name,
  * multiply this value by its alphabetical position in the list to obtain a
  * name score. For example, when the list is sorted into alphabetical order,
  * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the
  * list. So, COLIN would obtain a score of 938 53 = 49714. What is the total of
  * all the name scores in the file?
  */
object Problem22 extends App {
  val names = FileHelper.fromClasspath("names.txt").mkString.split(",")
  val sortedNameScores = names.map(_.init.tail).sorted.map(_.map(_ - 64).sum)
  val sumOfSortedNameScoresWithPosition =
    sortedNameScores.zipWithIndex.map(p => p._1 * (p._2 + 1)).sum
  println("Total: " + sumOfSortedNameScoresWithPosition)
}
