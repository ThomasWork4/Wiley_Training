package com.wiley.collections.Sets.bitSet

//import scala.collection.immutable.BitSet
import scala.collection.mutable
import scala.collection.mutable.BitSet

object bitSet extends App{
  //BitSet is the exact same as sorted set however it works only
  //with non-negative integers
  //Given this parameter it's cheaper than Sorted set because it
  //Works in 8 bit increments

  //This should work
  var numbers = mutable.BitSet(1,2,3,4,4356,678,123,567,879,324,123)
  //This will throw an illegal argument exception because in contains negative ints
  //var numbers = BitSet(1,2,3,4,4356,678,123,567,879,324,123,-10,-50,-1000000)
  //numbers.foreach((element:Int)=> println(element))

  //Adding elements
  numbers += 123
  //numbers.foreach((element:Int)=> println(element))

  //Removing elements
  numbers -= 123
  numbers.foreach((element:Int)=> println(element))

}
