package com.wiley.TypeHierarchy

object TypeHierarchy extends App{
  //Look at this link for an extremely useful diagram
  //https://docs.scala-lang.org/tour/unified-types.html#:~:text=Scala%20Type%20Hierarchy&text=It%20defines%20certain%20universal%20methods,Char%20%2C%20Unit%20%2C%20and%20Boolean%20.
  var test:Any = "Thomas"
  var test3:AnyRef = "Hello"
  var test2:AnyVal = 4.0

  //Nil signifies an empty singleton object
  var myList=Nil
  //myList.length - Will return 0

  //Used to initialize empty structures
  //None is a subtype of Option
  println(None.toList)

}

