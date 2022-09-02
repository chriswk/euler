package com.chriswk.euler

import com.chriswk.common.MathHelpers.isPalindromic

/** The decimal number, 585 = 10010010012 (binary), is palindromic in both
  * bases. Find the sum of all numbers, less than one million, which are
  * palindromic in base 10 and base 2. (Please note that the palindromic number,
  * in either base, may not include leading zeros.)
  */

object Problem36 extends App {

  val palindromicNumbers =
    (1 to 1000000).view.filter(p => isPalindromic(p, 2) && isPalindromic(p, 10))
  println(palindromicNumbers.sum)
}
