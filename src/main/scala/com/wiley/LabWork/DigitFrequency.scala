package com.wiley.LabWork

object DigitFrequency extends App{
  var storage = scala.collection.mutable.Map[Char, Int]()

  var x = 29743523874234L
  var Converted=x.toString

  for(i<-0 until Converted.length){
    val Current_Char = Converted.charAt(i)
    var total = 1
    for(z<-i + 1 until Converted.length) {
      if (Converted.charAt(z) == Current_Char) {
        total += 1
      }
    }
    if(!storage.contains(Current_Char)){
      storage.put(Current_Char, total)
    }
  }

  for ((k,v) <- storage) printf("Character: %s, Frequency: %s\n", k, v)

}
