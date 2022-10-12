package com.wiley.LabWork

object CharacterOccurences extends App{

  println("Please enter a string to search ")
  var first = scala.io.StdIn.readLine()
  println("Please enter the character to search for")
  var character:Char = scala.io.StdIn.readChar()
  var Occurences:Int = first.count(_ == character)
  println("Occurences of \'"+character+"\' in \""+first+"\" = "+Occurences)

}
