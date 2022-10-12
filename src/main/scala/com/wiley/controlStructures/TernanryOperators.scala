package com.wiley.controlStructures

object TernanryOperators {
  def main(args: Array[String]): Unit = {
    //call the check function and input the parameter -10
    val result = check(-10)
    println(result)
  }

  // functions that takes an integer and checks whether its greater than 0
  // if it is, return 1 else return -1
  // it's basically a function written on one line that's
  // main body is an if statement
  def check(a: Int) = if (a >= 0) 1 else -1
}
