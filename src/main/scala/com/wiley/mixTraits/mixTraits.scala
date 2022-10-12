package com.wiley.mixTraits

trait Print{
  def print()
}

abstract class PrintA4{
  def printA4()
}

//You can mix traits with abstract classes
//When implementing multiple inheritance
//These are called mixtraits
class A6 extends PrintA4 with Print {
  //Method from Print trait
  override def print(): Unit = {
    println("print sheet")
  }
  //Method from printA4 abstract class
  override def printA4(): Unit = {
    println("A4 sheet")
  }
}

object Mixtraits extends App {
  var a = new A6
  a.print()
  a.printA4()
}