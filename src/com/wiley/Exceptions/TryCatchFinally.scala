package com.wiley.Exceptions

class TryCatchFinally {

  def divide(a:Int, b:Int):Unit = {
    //In the try block goes the code suspected of throwing an exception
    try {
      //a / b
      var arr = Array(1,2)
      arr(10)
    }
      //In the catch block goes the response once the exception
      //has been caught
      //Exception cases are ran through one by one
      //The first one that catches the exception is triggered
    catch{
      //You can also choose to println(e) to print the exception itself
      case e:ArithmeticException => println("Oh no, Arithmetic Exception Occured: "+e)
      // All exceptions will be caught by exception
      case exp:Exception => println("Exception: "+exp)
      // Throwable will catch all errors and exceptions
      case th:Throwable => println("Throwable: "+th)
    }
    // Finally is used mainly when an exception gets thrown that isn't handled
      // The program will crash with the exception message, but not before the finally
      // block is executed
      //So if we force an unhandled exception, we will see the print line "If we want etc"
      //But we will not see the "Rest of code" print line
      //To test this, comment out the second and third catch cases
    finally{
      println("If we want to run code even after the exception, it goes here")
    }
    //Prints if we handle the exception, won't otherwise
    println("Rest of code")
  }
}

object anothermain extends App {
  var test = new TryCatchFinally
  test.divide(10,0)
  //test.throwException()


}
