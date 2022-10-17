package com.wiley.collections.Map

object Maps extends App{

  var firstmap = Map(("Thomas", 22), ("Jinesh", 36))
  var secondmap:Map[String,Int] = Map("Thomas" -> 22,
  "Jinesh" -> 36,
    "Charlotte" -> 22
  )

  println(firstmap)
  println(secondmap)

  //Access a key's value in the map
  println(firstmap("Thomas"))
  println(secondmap("Thomas"))

  //Remove an entry using the key - Only works with var map, not val
  firstmap -= "Thomas"
  println(firstmap)

  //Add value to map - Only works with var map, not val
  firstmap += ("Daniel" -> 22)
  println(firstmap)

  println("")
  //Map for loop
  for ((key,value) <- firstmap) printf("key: %s, value: %s\n", key, value)
  println("")
  //Map for each loop
  firstmap foreach {case (key, value) => println (key + "-->" + value)}
  println("")
  //For each loop saved in a tuple
  firstmap.foreach((e: (String, Int)) => println(e._1 + "=" + e._2))
  println("")
  //For each loop over just keys
  firstmap.keys.foreach((key:String) => println(key))
  println("")

}
