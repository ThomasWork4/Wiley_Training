package com.wiley.HigherOrderFunctions

object MultiLineExpressions extends App{
println(add1(10, 20))

  // Second value in this function get's returned, not the first
  // Because code is read top to bottom so the latest return statement
  // is executed
  // If we add a + to the first line in the function, the compiler reads
  // it as an unfinished statement and continues to the next line to finish
  // therefore the output would be a + b
  // and not just b
  def add1(a:Int, b:Int): Int = {
    a
    b
  }
}
