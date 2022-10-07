package com.wiley.Inheritance

//Parent / Super class
class SuperAnimal(private var NumberOfLegs:Int = 0, private var AnimalName:String = "None"){

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

// Child class that extends parent class and inherits it's attributes and methods
class Mammal extends SuperAnimal {
  def Run():Unit ={
    println("I'm running")
  }
}

// Grand child class that extends child class and inherits it's
// attributes and methods and that of the super class / parent class
class Mammoth extends Mammal{
  def Random():Unit = {
    println("I'm a Mammoth")
  }
}

object testMethod extends App {
  var Mammal = new Mammal()
  var Mammoth = new Mammoth()
  Mammoth.setLegs(4)
  Mammoth.setName("Mammoth")
  Mammoth.Run()
  Mammoth.Random()
}