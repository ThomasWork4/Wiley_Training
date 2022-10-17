package com.wiley.mapFunction

object mapFunction extends App{
  //Map function is really good for performing transformations on
  //collections without using a for loop,
  //It's less computationally expensive
  //The best use here is to use a function to perform the transformation

  val s1 = Set(5,1,3,2,4,56, 100)
  val result = s1.map(x=> x*x)
  println(result)

  val s2 = Set("Thomas", "Charlotte", "Dan", "Ben")
  val result2 = s2.map(_.toUpperCase)
  println(result2)

}
