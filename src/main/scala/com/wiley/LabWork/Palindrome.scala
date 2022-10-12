package com.wiley.LabWork

import java.security.KeyStore.TrustedCertificateEntry
import util.control.Breaks._

object Palindrome extends App{
  println("Please enter a string")
  var first = scala.io.StdIn.readLine()
  var end = first.length
  var Word_length = first.length-1
  for(a <- 0 to Word_length){
    if(first.charAt(a) == first.charAt(Word_length)){
      Word_length -= 1
    }
    else{
      println("Word is not a palindrome")
      break
    }
  }
  println("Word is a palindrome")
}
