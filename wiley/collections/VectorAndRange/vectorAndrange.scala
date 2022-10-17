package com.wiley.collections.VectorAndRange

import scala.collection.immutable.Nil.patch

//Vector came before arrays
//It stores element anywhere in the list
//Its safer for multi-threading
//It's immutable

object vectorAndrange extends App{

  var test:Vector[Int] = Vector(5,4,2,6,5)
  var test2 = Vector("Hello", "World", 10, 5, 100, 50)
  var test3: Vector[Int] = Vector.empty

  println(test)
  println(test3)

  //Adding elements to vectors
  println(test :+ 10)

  //Merging vectors
  //You can also do ++ but it's slightly more computationally expensive
  println(test.concat(test2))

  //Sorting vectors
  println(test.sorted)

  //Removal from vectors is quite hard
  //This works well but is expensive to do
  println(test.zipWithIndex.filterNot(_._2 == 0).map(_._1))

  //Range data type
  var rangeList = 1 to 10
  rangeList.foreach(print(_))
  println("")

  //Range converted to list
  var rangeListLonger = (1 to 20).toList
  rangeListLonger.foreach(print(_))
  println("")
  //^ Ranges can be converted to Sets, Lists, Sequences, Array, ArrayBuffer, etc

  var range = (1 to 10).toString()
  range.foreach(print(_))
  println("")
  //^ This is weird. It converts a range one to 10, to the string "Range 1 to 10"

  var range2 = ('a' to 'z')
  range2.foreach(print(_))
  //You can also range characters which is fairly useful
}
