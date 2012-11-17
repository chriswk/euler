package com.chriswk.euler

object Problem16 extends App {
  val answer = BigInt(2).pow(1000).toString.view.map(_.asDigit).sum
  println(answer)
}