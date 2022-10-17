package com.wiley.LabWork

abstract class Donut(name:String=""){
  def printName():Unit = {
    println(name)
  }
}

case class VanillaDonut(name:String) extends Donut
case class GlazedDonut(name:String) extends Donut


class Pastry[P <: Donut](p : P) {
  def name():Unit={
    p.printName()
  }
}

object slides extends App {
  var obj1 = new Pastry[VanillaDonut](new VanillaDonut("Vanilla Donut"))
  obj1.name()
  var obj2 = new Pastry[Donut](new GlazedDonut("Glazed Donut"))
  obj2.name()
}