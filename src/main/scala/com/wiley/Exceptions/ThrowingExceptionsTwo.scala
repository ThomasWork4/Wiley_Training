package com.wiley.Exceptions

import scala.util.control.Breaks.break

class ThrowingExceptionsTwo {
  def validate(age:Int):Unit = {
    //Throwing exceptions is good for validating user input
    if (age > 18) {
      throw new ArithmeticException("Arithmetic exception")
    }
    else {
      println("Valid input")
    }
  }

  //Just as a seperate thought I had, ignore this
  //A function to validate user input
  //This function reruns until a valid input is given
  def validateInput():Unit = {
    println("Please enter your age")
    var Entry = scala.io.StdIn.readInt()
    try {
      if (Entry > 18) {
        throw new ArithmeticException("Arithmetic exception")
      }
      else{
        println("Input is valid")
      }
    }
    catch{
      case e:ArithmeticException=> println("Arithmetic Exception, try again")
        validateInput()
    }
  }
}

object mainthird extends App {
  var test = new ThrowingExceptionsTwo
  //test.validate(12)
  test.validateInput()
}