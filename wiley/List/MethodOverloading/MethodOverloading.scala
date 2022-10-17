package com.wiley.List.MethodOverloading

class MethodOverloading {
  //Method overloading
  //Having same named methods with different parameters
  //NOTE the first method that fits the parameters that you've entered will be executed
  //For example, if I entered 2 numbers, the first method this fits is the first add method
  //Then If i enter 2 numbers a string and a boolean, the third add method is the one that executes
  def add(a:Int, b:Int):Unit = {
    var sum = a+b
    println(sum)
  }

  def add(a:Int,b:Int,c:String)={
    var sum = a+b
    println(sum)
    println(c)
  }

  def add(a:Int, b:Int,c:String,d:Boolean):Unit = {
    var sum = a+b
    println(sum)
    println(c)
    println(d)
  }

  //Different type of method overloading with same number of parameters
  //but different data types
  //The method that get's picked will correspond to the data type of the
  //Parameters provided by you
  def add(a:Double, b:Double):Unit = {
    var sum = a + b
    println(sum)
  }

  //This won't work, because the parameter size and types are the same
//  def add(a: Int, b: Int): Unit = {
//    var sum = a * b
//    sum
//  }
}

object main extends App {
  var test = new MethodOverloading()
  test.add(1,3)
  test.add(1,5,"Thomas")
  test.add(1,10,"Sam", true)
  test.add(1.0,2.0)
}
