package com.wiley.LabWork

import scala.collection.mutable.ListBuffer

object LongestRepeatingSubstring extends App{
  var Test:String = "Thomassadler"
  var Longest:Int = 0
  var Storage = ListBuffer[Char]()
  var Global:Int = 0
  for(a <- Test){
    if(!Storage.contains(a)){
      Storage += a
      Longest += 1
    }
    else{
      if(Longest > Global){
        Global = Longest
      }
      Longest = 0
    }
  }
  println(Global)


}
