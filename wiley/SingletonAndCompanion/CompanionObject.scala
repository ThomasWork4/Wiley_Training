package com.wiley.SingletonAndCompanion

/*
A companion object is an object that's declared in the same file as a class ,
and has the same name as the class.
*/

//Class named CompanionClass
class CompanionClass {
  def hello(): Unit = {
    println("This is a companion class")
  }
}

object main extends App {
  //object that is declared that has the same name as the class
  new CompanionClass().hello()
  println("Companion Object")
}
