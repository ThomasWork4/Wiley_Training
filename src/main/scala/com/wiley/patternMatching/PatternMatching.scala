package com.wiley.patternMatching

object PatternMatching extends App {
  //var a = 10
  var a = "Hello"
  a match {
    case "Hello" => println("First Word")
    case "There" => println("Second Word")
    case "World" => println("Third Word")
    case _ => println("None")
  }
}
