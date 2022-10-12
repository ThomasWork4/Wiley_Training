package com.wiley.HigherOrderFunctions

object NestedFunctions {
  def main(args: Array[String]): Unit = {
    var result = Concatenate("Hello ", "There ", "World")
    println(result)
    maxAndMin(5, 10)

  }


  // Nested function (function inside another function)
  // you call the first function
  // Then the function inside runs, until the string result
  // is put together
  def Concatenate(a:String, b:String, c:String):String = {
    def Concatenate2(x:String, y:String):String = {
      x + y
    }
    Concatenate2(a, Concatenate2(b, c))
  }

  // Example taken from google. A nested function
  // that finds the max number out of the 2 parameters provided
  // by using the maxValue nested function
  def maxAndMin(a: Int, b: Int) = {
    def maxValue() = {
      if (a > b) {
        println("Max is: " + a)
      }
      else {
        println("Max is: " + b)
      }
    }
    maxValue()
  }
}
