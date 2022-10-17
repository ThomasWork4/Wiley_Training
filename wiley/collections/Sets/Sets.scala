package com.wiley.collections.Sets

object Sets extends App {
  var set1 = Set()
  //Sets remove duplicate values.
  //The set below will only print Football once
  //You can store multiple data types in the set however it's fairly computationally expensive to do so
  //You should always specify a specific data type in the usual way and store only what it takes
  var games = Set("Baskeball", "Hockey", "Football", "Football", 7)
  //var games:Set[String] = Set("Baskeball", "Hockey", "Football", "Football")
  println(set1)
  println(games)

  //For loop
  games.foreach(x => println(x))
}
