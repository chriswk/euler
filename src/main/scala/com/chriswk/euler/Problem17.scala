package com.chriswk.euler

import com.chriswk.common.Profiling

/** * If the numbers 1 to 5 are written out in words: one, two, three, four,
  * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total. If all
  * the numbers from 1 to 1000 (one thousand) inclusive were written out in
  * words, how many letters would be used? NOTE: Do not count spaces or hyphens.
  * For example, 342 (three hundred and forty-two) contains 23 letters and 115
  * (one hundred and fifteen) contains 20 letters. The use of "and" when writing
  * out numbers is in compliance with British usage.
  */

object Problem17 extends App {

  val units = Array(0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8)
  val tens = Array(0, 0, 6, 6, 5, 5, 5, 7, 6, 6)

  lazy val name: Int => Int = {
    case n if (n < 20)  => units(n)
    case n if (n < 100) => tens(n / 10) + (if (n % 10 > 0) units(n % 10) else 0)
    case n if (n < 1000) =>
      name(n / 100) + 7 + (if (n % 100 > 0) 3 + name(n % 100) else 0)
    case 1000 => 11
  }

  val answer = Profiling.timed(Profiling.printTime("Numbers to letters in ")) {
    (1 to 1000).map(name).sum
  }
  print(answer)
}
