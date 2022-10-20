package com.wiley.Threads

object Implicit extends App{
  val value = 10

  //Implicit variables are variables that can be used as a default value for
  //Functions that accept implicit integers when no parameter has been passed at
  //Calltime

  implicit val multiplier = 3

  def multiply(implicit by:Int) = value * by

  //Notice that I haven't passed anything to multiply but it still works -- ^ Read above
  //This method call will take the implicit value 3 automatically
  val result = multiply


  //The result here should be 30
  println(result)

}
