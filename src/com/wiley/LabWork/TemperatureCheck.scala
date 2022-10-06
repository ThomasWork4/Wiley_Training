package com.wiley.LabWork

object TemperatureCheck extends App{
  println("Please enter a temperature: ")
  println("Please enter another temperature: ")
  var number = scala.io.StdIn.readInt()
  var number2 = scala.io.StdIn.readInt()

  if(number < 0 && number2 > 100 || number2 < 0 && number > 100){
    println("One of the number is less than zero, and the other is greater than 100")
  }
  else{
    println("Nothing interesting here")
  }


}
