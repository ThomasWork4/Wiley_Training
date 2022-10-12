package com.wiley.controlStructures

object ControlStructures extends App{

  //Checking for odd and even numbers using for loop and if statement
  val nums: List[Int] = List(1, 2, 3, 4)
  var number: Int = 25
  for (numbers <- nums) {
    if (numbers % 2 == 0) {
      println("Even")
    }
    else {
      println("Odd")
    }
  }


  //Checking grade boundaries using else if
  var score: Int = 88
  if (score >= 0 && score < 50) {
    println("Fail")
  }
  else if (score >= 50 && score < 60) {
    println("D grade")
  }
  else if (score >= 60 && score < 70) {
    println("C grade")
  }
  else if (score >= 70 && score < 80) {
    println("B grade")
  }
  else if (score >= 80 && score < 90) {
    println("A grade")
  }
}
