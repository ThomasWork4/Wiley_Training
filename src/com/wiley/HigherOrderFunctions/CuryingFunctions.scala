package com.wiley.HigherOrderFunctions
//Currying is the process of converting a function with multiple
// arguments into a sequence of functions that take one argument.
// Each function returns another function that consumes the following
// argument.


// You can give one input to a function that expects to inputs
// However you won't be able to print the result of the function
// Until you provide a second function, it will be in a kind of
// "Waiting state"
object CuryingFunctions extends App{
  //val result = add(10)(10)
    //println(result)
    val addlt=add(10)_
    val result2=addlt(3)
    println(addlt)


  def add(a:Int)(b:Int): Int = {
    a + b
  }
}
