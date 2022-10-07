package com.wiley.Inheritance


class Animal(var NumberOfLegs:Int = 0, var AnimalName:String = "None"){

  def setLegs(Value:Int):Unit={
    NumberOfLegs=Value
  }

  def setName(Value:String):Unit={
    AnimalName=Value
  }

  def ShowDetails():Unit = {
    println(NumberOfLegs)
    println(AnimalName)
  }
}

class Amphibian extends Animal(){
  def Swim():Unit ={
    println("I'm Swimming")
  }
}

object mainPractice extends App {
  var Salmon = new Amphibian()
  Salmon.setName("Salmon")
  Salmon.setLegs(0)
  Salmon.ShowDetails()
  Salmon.Swim()

}