package com.wiley.LabWork

object SumOfDigits extends App{
  var x = 121
  val lastDigit = x % 10 // the last (least significant digit) is easy to find
  if (x > lastDigit) { // only numbers with multiple digits will be handled
    while ( {
      x >= 10
    }) { // loop until you find the first (most significant) digit
      x = x / 10
    }
  }
  val sum = lastDigit + x

  println(sum)

}
