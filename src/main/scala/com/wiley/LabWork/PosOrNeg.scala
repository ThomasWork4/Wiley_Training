package com.wiley.LabWork

object PosOrNeg extends App{
  println("Please enter a number?")
  var number = scala.io.StdIn.readInt()
  if(number < 0){
    println("Negative Number")
  }
  else if(number >= 0){
    println("Positive Number")
  }

}
