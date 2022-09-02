package com.chriswk.euler

/** * You are given the following information, but you may prefer to do some
  * research for yourself.
  *
  * 1 Jan 1900 was a Monday. Thirty days has September, April, June and
  * November. All the rest have thirty-one, Saving February alone, Which has
  * twenty-eight, rain or shine. And on leap years, twenty-nine. A leap year
  * occurs on any year evenly divisible by 4, but not on a century unless it is
  * divisible by 400. How many Sundays fell on the first of the month during the
  * twentieth century (1 Jan 1901 to 31 Dec 2000)?
  */
object Problem19 extends App {
  val monthLengths = Array(31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 31, 31)

  val ls =
    for (y <- 1900 to 2000; m <- 1 to 12)
      yield
        if (m == 2)
          if (if (y % 100 == 0) y % 400 == 0 else y % 4 == 0) 29 else 28
        else
          monthLengths(m - 1)
  val fs = ls.foldLeft(List(1))((ws, l) => ((ws.head + l) % 7) :: ws)

  println(fs.count(_ == 0))

}
