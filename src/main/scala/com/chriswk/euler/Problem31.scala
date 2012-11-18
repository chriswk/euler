package com.chriswk.euler

import com.sun.corba.se.impl.encoding.IDLJavaSerializationInputStream

/** *
  * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
  * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
  * It is possible to make £2 in the following way:
  * 1£1 + 150p + 220p + 15p + 12p + 31p
  * How many different ways can £2 be made using any number of coins?
  * */
object Problem31 extends App {
  def permutations(denominations: List[Int], goal:Int): Int = denominations match {
    case h :: t =>
      if (h > goal) 0 else if (goal == h) 1 else permutations(denominations, goal - h) + permutations(t, goal)
    case _ => 0
  }
  val answer = permutations(List(1,2,5,10,20,50,100,200), 200)
  println(answer)
}
