package com.wiley.LabWork

import scala.util.Random

object ExtraLetter extends App{


  CheckForExtraLetter("thomas")

  def CheckForExtraLetter(word1:String): Unit ={
    var Second = scala.util.Random.shuffle(word1)
    val random:Char = Random.nextPrintableChar()
    var Index = Random.nextInt(Second.length)
    Second += random.toString
    println(Second)
    for(a <- Second){
      if(!word1.contains(a)){
        printf("The extra letter is %c",a)
      }
    }
  }

}
