package com.wiley.Inheritance


class Animal(var NumberOfLegs:Int = 0, var AnimalType:String = "None"){

  def setLegs(Value:Int):Unit={
    NumberOfLegs=Value
  }

  def setType(Value:String):Unit={
    AnimalType=Value
  }

  def ShowDetails():Unit = {
    println(NumberOfLegs)
    println(AnimalType)
  }
}

class Salmon extends Animal(){}

object mainPractice extends App {
  var Fish = new Salmon()
  Fish.setType("Fish")
  Fish.setLegs(0)
  Fish.ShowDetails()

}