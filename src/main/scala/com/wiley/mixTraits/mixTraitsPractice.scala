package com.wiley.mixTraits

trait Print1{
  def print()
}

abstract class PrintA41{
  def printA4()
}


class A61 extends PrintA41 {
  //Method from Print trait
  def print(): Unit = {
    println("print sheet")
  }
  override def printA4(): Unit = {
    println("A4 sheet")
  }
}

object MixtraitsPractice extends App {
  //This version mixes the Print1 trait
  // with class A61 (which extends abstract clas PrintA41)
  // at runtime. This is multiple inheritance again.
  // Object from class A61 has inherited from PrintA41 and Print1
  //This typically happens if you realize after the fact, that you
  //need specific method or attributes from the trait
  var a = new A61 with Print1
  a.print()
  a.printA4()
}