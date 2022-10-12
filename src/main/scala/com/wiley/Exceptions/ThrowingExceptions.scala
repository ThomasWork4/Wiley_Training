package com.wiley.Exceptions

/*
              Object
                |
                V
            Throwable
          |           |
          V           V
        Exception   Error --> Virtual machine or Assertion error
        |        |
        V        V
     Checked Unchecked
        |         |
        V         V
 Compile time  Runtime

Checked Exception happen at compile time i.e. When you first run the code
It will return immediately

Unchecked Exception happen at runtime i.e. whenever your code tries to do something
that isn't possible
*/


//Handling an exception will allow the code to continue running if required
//As well as alert the user to any bugs in the code

class ThrowingExceptions {

  def divide(a:Int, b:Int):Unit = {
    a/b
    //This won't print when the exception is thrown
    println("Rest of code is executing")
  }

  def throwException():Unit = {
    throw new Exception("Exception message")
  }
}

object main extends App {
  var test = new ThrowingExceptions
  //v Will throw an arithmetic exception because we are trying to divide by 0
  //test.divide(10,0)
  //We can implicitly throw an exception if we need to
  //test.throwException()


}
