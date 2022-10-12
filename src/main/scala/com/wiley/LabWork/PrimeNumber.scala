package com.wiley.LabWork

object PrimeNumber extends App {
  println("Please enter a number?")
  var number = scala.io.StdIn.readInt()
  println(isPrime(number))

  def isPrime(value: Int): String = {
    for (a <- 2 to value / 2) {
      if (value % a == 0) {
        return "The number is not prime"
      }
    }
    "The number is prime"
  }
}
