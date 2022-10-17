package com.wiley.collections.Sets

object UnionIntersection extends App {
  var games = Set("Baskeball", "Hockey", "Football", "Football")
  var more_games = Set("Golf", "Swimming", "Hockey")
  var third = games.union(more_games)
  println(third)
  //Same as &
  var fourth = games.intersect(more_games)
  println(fourth)
  var fifth = games.diff(more_games)
  println(fifth)
  //Same as intersect
  var sixth = (games & more_games)
  println(sixth)
}
