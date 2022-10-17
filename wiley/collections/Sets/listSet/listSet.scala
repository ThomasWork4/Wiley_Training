package com.wiley.collections.Sets.listSet

import scala.collection.immutable.ListSet

object listSet extends App{
  var listSet:ListSet[Int] = ListSet(1,2,3,4,5,6,7,8)
  //List set maintains the order in which they are originally
  //They also have the usual Set functionality with removing duplicates

  var secondlistSet:ListSet[Int] = ListSet(9,10,11)
  var thirdlistSet = ListSet("Hello", "World", 15, 100)

  listSet.foreach((element:Int)=>println(element))

  //Adding values
  listSet += 100

  //Deleting values
  listSet -= 100

  //For the situation in which you may need each elements index
  for((element,index) <- listSet.zipWithIndex){
    println(element, index)
  }

  //Concatenating sets
  println(listSet.concat(secondlistSet))

  //Trying to concat an Int and String List set
  var third = listSet.concat(thirdlistSet)
  third += "Thomas"
  third += 1000
  println(third)





}
