package com.wiley.scalacohort.Tuples

object Tuples extends App{
  //One implementation
  val tuple:(String, Int)=("Thomas", 22)
  //Another implementation
  val another_tuple = "Thomas" -> 22
  //3 value tuple
  val tuple3 :(String, Int, Boolean)=("Thomas",22,true)


  //println(tuple)
  //println(another_tuple)
  //println(tuple3)
  //println(tuple._1)

  //Taking values from another tuple
  val(username,anotherage)=tuple
  val(_,thirdage)=tuple

  //More Print statements
  //print(thirdage)
  //println(username, anotherage)
  //println(tuple3._1, tuple3._2, tuple._1)

  //Iterator to print
  //tuple.productIterator.foreach{i=>println(i)}

  //Create a map
  val data = Map("A" -> 20,
    "B" -> 25,
    "C" -> 30,
    "D" -> 35)

  //Print the elements with a seperator
  //println(data.mkString(" || "))

  //Checking whether the person information inside a map is older than 18
  //Create a case class
  case class Person(name: String, isAdult: Boolean)
  // Convert String, Int entries to Person class format
  val createPerson: (String, Int) => Person = (name, age) => Person(name, age > 18)
  //.map applies the createPerson function to the map
  val users=data.map(createPerson.tupled)
  //print the result
  println(users)
}
