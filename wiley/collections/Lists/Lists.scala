package com.wiley.collections.Lists

import scala.collection.mutable.ListBuffer
import scala.util.Random

object Lists extends App{
  var Storage = List(1,2,3,4,5,6)

  var Storage2 = ListBuffer(7,8,9,10)

  println(Storage)
  println(Storage2)

  //Adding to a list buffer
  Storage2 += 100
  println(Storage2)

  //Removing from a list buffer
  Storage2 -= 100
  println(Storage2)

  //Converting to a regular list
  Storage2.toList

  //Then concatenate the lists
  println(Storage.concat(Storage2))

  //Using a foreach loop
  Storage.foreach((element:Int)=>print(element+" "))
  println("")

  //Shuffle a list
  Storage = Random.shuffle(Storage)
  println(Storage)

  //Order a list
  println(Storage.sorted)

}