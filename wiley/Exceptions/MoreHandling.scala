package com.wiley.Exceptions

class MoreHandling {

  def throwException(): Unit = {
    throw new Exception("I have thrown an exception manually")
  }


  def divide(a: Int, b: Int): Unit = {
    try{
      a / b
      var arr = Array(1, 2)
      //This line will throw an error
      throwException()
      //This line will also throw an error (Pick one of the two to test at a time)
      //arr(10)
      //We are trying to access the 10th index of an array of size 2
    }
    catch{
      case e:ArithmeticException=> println("Arithmetic Exception")
      //Throwable, being the highest in the exception hierarchy, is great for catching exceptions
      //That you might not have foreseen and declared, it catches ALL exceptions
      //In this case, there will be an index out of bounds exception
      //Throwable will catch this.
      //Similar to previous, if you want to print whatever exception you get,
      //Just print the case name, in this case "ex"
      case ex: Throwable=> println("There has been an exception here, "+ex)
    }
  }

}


object maintest extends App{
  var test = new MoreHandling
  test.divide(100, 10)

}