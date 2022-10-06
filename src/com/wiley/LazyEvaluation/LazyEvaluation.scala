package com.wiley.LazyEvaluation

object LazyEvaluation extends App{
  //Lazy evaluation is also called "Call-by-need"
  //The lazy expression, in this case line 6
  //Won't be evaluated until it's first use

  //Simplest example I can give
  //This won't print when lazy is used
  lazy val foo = println("Initialized")
  //But when you explicitly call it, it does
  foo
  //NOTE if you took the lazy keyword out, it would work first time
  //Without having to call the variable

lazy val myExpensiveValue = myExpensiveFunction()
var settings:Boolean = true


  if(settings){
      //This will print nothing by itself
      //myExpensiveValue
      //This on the other hand, will print the required output
      var testing = myExpensiveValue
      println(testing + " Here")
    }
    else{
      println("Go to sleep")
    }

def myExpensiveFunction(): Int = {
  println("Thomas")
  10
}
}