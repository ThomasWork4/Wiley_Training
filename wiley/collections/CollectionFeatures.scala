package com.wiley.collections

object CollectionFeatures extends App{
  var another:Set[String] = Set("Hello")
  var games:Set[String] = Set("Baskeball", "Hockey", "Football")
  //Prints the first option
  println(games.head)
  //Adds a value to the set
  games+="Extra"
  println(games)
  //Returns a boolean for whether the set is empty
  println(games.isEmpty)
  //To convert the set to an array
  println(games.toArray.mkString("Array(", ", ", ")"))
  //To convert the set to a list
  println(games.toList)
  //Merging sets
  println(games.concat(another))
  //Another way to merge sets
  println(games++another)
  //Looping through each
  games.foreach(x => println(x))
  //Used to count the number of elements in the set
  val results = games.count(z => true)
  println(results)
  //To find a specific result adhering to a criteria
  val result= games.find(x => {x == "Hockey"})
  println(result)
  //equivalent to .contains, returns a boolean if the value is contained in the set
  println(games.apply("Thomas"))
  //Print the size of the set
  println(games.size)
  //Remove element from the set
  games-="Hockey"
  println(games)

}
