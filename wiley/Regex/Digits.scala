package com.wiley.Regex
import scala.util.matching.Regex

object Digits extends App{

  //Find all the digits in a str - d is used for checking digits
  //D - is used for all non-digits
  //S - is used for all strings
  //s - is used for all the spaces
  //If we want to look for specific letters "c|d" - Looks for c's and d's in the string
  //https://www.tutorialspoint.com/scala/scala_regular_expressions.htm#
  //Link above to see all of the other regular expressions
  val reg = new Regex("\\D")
  val reg2 = new Regex("\\d")
  val reg3 = new Regex("\\S")
  val reg4 = new Regex("\\s")
  val reg5 = new Regex("\\w")
  val reg6 = new Regex("\\W")
  val reg7 = new Regex("\\A")
  val reg8 = new Regex("\\Z")
  val reg9 = new Regex("\\z")
  val reg10 = new Regex("H|W")
  val reg11 = new Regex("lo*")
  val reg12 = new Regex("^")
  val reg13 = new Regex("$")
  val reg14 = new Regex("[aeio]")
  val reg15 = new Regex("[a-z]")
  val reg16 = new Regex("[A-Z]")
  val reg17 = new Regex("[a-zA-Z0-9]")

  val str = "Hello 4World my name3 is Thomas Sadler H1"

  println("Non Digits => " + reg.findAllIn(str).mkString(", "))
  println("Digits => " + reg2.findAllIn(str).mkString(", "))
  println("Non Whitespace => " + reg3.findAllIn(str).mkString(", "))
  println("Whitespace => " + reg4.findAllIn(str).mkString(", "))
  println("Characters => " + reg5.findAllIn(str).mkString(", "))
  println("Nonword Characters => " + reg6.findAllIn(str).mkString(", "))
  println("Beginning of string => " + reg7.findAllIn(str).mkString(", "))
  println("End of string 1.0 => " + reg8.findAllIn(str).mkString(", "))
  println("End of string 2.0 => " + reg9.findAllIn(str).mkString(", "))
  println("H's or W's => " + reg10.findAllIn(str).mkString(", "))
  println("Instances of lo  or l => " + reg11.findAllIn(str).mkString(", "))
  println("Beginning of the line => " + reg12.findAllIn(str).mkString(", "))
  println("End of the line => " + reg13.findAllIn(str).mkString(", "))
  println("Vowels => " + reg14.findAllIn(str).mkString(", "))
  println("Lowercase letters => " + reg15.findAllIn(str).mkString(", "))
  println("Uppercase letters => " + reg16.findAllIn(str).mkString(", "))
  println("Everything => " + reg17.findAllIn(str).mkString(", "))








}
