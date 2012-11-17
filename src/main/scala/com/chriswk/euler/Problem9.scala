package com.chriswk.euler

object Problem9 extends App {
  def isTriplet(a: Int, b: Int, c: Int, sum: Int): Boolean = (a*a) + (b*b) == (c*c) && a + b + c == sum && a < b && b < c

  def tripletForSum(sum: Int) = {
	  val triplets = for {
		  a <- (1 to sum).view
		  b <- 1 to sum - a
		  c <- 1 to sum - a - b
		  if(isTriplet(a, b, c, sum))
	  } yield (a,b,c)
	triplets.head	
  }
  val answerTriplet = tripletForSum(1000)
  val answer = answerTriplet._1 * answerTriplet._2 * answerTriplet._3
  println(answer)
}


