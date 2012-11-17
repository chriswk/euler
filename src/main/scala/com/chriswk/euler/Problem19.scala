package com.chriswk.euler

object Problem19 extends App {
  val monthLengths = Array(31,0,31,30,31,30,31,31,30,31,30,31)

  val ls = for(y <- 1900 to 2000; m <- 1 to 12) yield
    if(m == 2)
      if (if (y % 100 == 0) y % 400 == 0 else y % 4 == 0) 29 else 28
    else
      monthLengths(m - 1)

  val fs = ls.foldLeft(List(1))((ws, l) => ((ws.head + 1) % 7) :: ws)

  println(fs.count(_ == 0))


}