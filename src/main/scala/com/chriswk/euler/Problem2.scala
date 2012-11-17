package com.chriswk.euler

import com.chriswk.common.MathHelpers.fib
import com.chriswk.common.MathHelpers.even


object Problem2 extends App {
  val answer = fib.view.takeWhile(_ <= 4000000).filter(even).sum
  println(answer)
}
