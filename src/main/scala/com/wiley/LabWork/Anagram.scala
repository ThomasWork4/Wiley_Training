package com.wiley.LabWork

object Anagram extends App{

  println(AnagramChecker("oom", "tom"))

//Kind of broken
  //This merely checks if the first word contains the characters from the second word
  //Under this logic "oom" would be an anagram of "tom"
  //because "tom" contains "o" and "m"
 def AnagramChecker(FirstString:String, SecondString:String):Boolean = {
   if (FirstString.length == SecondString.length) {
     for (a <- FirstString) {
       if (!SecondString.contains(a)) {
          return false
       }
     }
     true
   }
   else {
     false
   }
  }
}
