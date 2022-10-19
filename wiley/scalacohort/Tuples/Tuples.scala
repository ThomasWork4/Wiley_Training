package com.wiley.scalacohort.Tuples

object Tuples{
  //One implementation
  val tuple:(Int, Int, Int)=(12, 22 ,30)
  //Another implementation
  val another_tuple = "Thomas" -> 22
  //3 value tuple
  val tuple3 :(String, Int, Boolean)=("Thomas",22,true)


  //println(tuple)
  //println(another_tuple)
  //println(tuple3)
  //println(tuple._1)


  //More Print statements
  //print(thirdage)
  //println(username, anotherage)
  //println(tuple3._1, tuple3._2, tuple._1)

  //Iterator to print
  tuple.productIterator.foreach{i=>println(i)}


}
