package com.wiley.HigherOrderFunctions

object AnonymousFunctions extends App{

  //Basically a function written as a variable
  var result1=(a:Int, b:Int)=>a+b
  println(result1(10,10))

  //This example uses underscores
  //underscores are used as wildcards when you don't know the
  //name or the type of the value being passed into the anonymous function
  //It's written slightly differently to the example above
  var result2=(_:Int)+(_:Int)
  println(result2(20,20))

  var result3=(_:String)+(_:String)
  println(result3("Hello ","World"))

  //Example that uses composition
  var result4=(_:Int)*(_:Int)
  println(result4(10, result2(1, 2)))

  //Example that uses a function from another object
  println(result4(10, SupplementaryObject.add(10)))
}
