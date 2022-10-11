package com.wiley.stringManipulation


object stringFunctions extends App {

  var s1 = "Thomas "
  var s2 = "Sadler"

  //SUBSTRINGS
  //To print substring with 2 indexes
  println(s1.substring(0, 3))
  //To print substring starting from a certain character
  println(s1.substring(3))


  //CONCATENATION
  //DO NOT USE PLUS SIGN FOR THIS IF POSSIBLE
  //Using the plus sign for concatenation is extremely
  //Computationally expensive
  var s3 = s1 + s2
  //Use the concat method instead
  //This is what is used as standard in the industry
  var s4 = s1.concat(s2)
  println(s3)
  println(s4)



}
