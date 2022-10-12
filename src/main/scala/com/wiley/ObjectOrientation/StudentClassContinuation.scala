package com.wiley.ObjectOrientation

object StudentClassContinuation extends App {
  // Instantiating a parameterized object
var s=new Student(100, "Abc")
s.show()
  //s.addAndMultiplyBy2()
  s.show()
}


// A parameterized class where you set the object attributes at initialization
// We have one show method to show our current attributes
class Student(var id:Int,var name:String) {
  def show(): Unit = {
    println(s"$id---->$name")
  }

  //Trying to incorporate higher order functions, this is unfinished
//  def addAndMultiplyBy2(): Unit = {
//    id = multiplyBy2(com.wiley.HigherOrderFunctions.SupplementaryObject.add(id))
//  }
//
//  def multiplyBy2(newID:Int):Unit = {
//    id = newID * 2
//  }
}
