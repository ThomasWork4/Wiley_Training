package com.wiley.Operators

object Operators extends App {

  //Variables also known as operands or instance variables
  var a=50
  var b=5
  var c=2
  var d=true
  var e=false
  var result=0

  //Arithmetic operators
  println("Addition " + a, b, a+b)
  println("Subtraction " + a, b, a-b)

  //Relational operator
  if (a == b)
  {println("Values are the same")}
  else{
    println("Values are not the same")}

  //Logical operator
  // || takes the logical OR of each values truth tables
  println("Logical or of d || e is "+(d||e))

  // & takes the logical AND of each values truth tables
  // One & is for bitwise operations, && is something different
  result = a&b
  println("Bitwise AND of a and b is"+result)

  // commonly used for checking against multiple criteria
  // inside control structures
  var Check = 10
  if(Check < 20 && Check > 5){
    println("It's between 5 and 20")
  }

  //assignment operator
  println("Addition assignment is "+(a+=b))

}
