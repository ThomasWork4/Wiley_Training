package com.wiley.Functions

object Recursion {
  def main(args: Array[String]): Unit = {
   println(RecursiveFunction(15, 2))
    println(FactorialFunction(5))
  }

  // An example recursive function
  def RecursiveFunction(a: Int, b: Int): Int = {
    if (b == 0) {
      0
    }
    else {
      a+RecursiveFunction(a,b-1)
    }
  }

  // Recursive function that works out the factorial by calling itself
  def FactorialFunction(a:Int): Int = {
    if(a == 0){
      1
    }
    else {
      a * FactorialFunction(a - 1)
    }
  }
}
