package com.wiley.traits

//Traits are basically the same as java interfaces
//They are completely abstract classes essentially
//NOTE that multiple inheritance is possible with traits
trait Human {
  def Run(){}

  def Swim(){}

  def Walk(){}
}

trait Animal {
  def Howl(){}

  def Sleep(){}
}

//Similar to abstract classes, we inherit the trait
//And define the abstract methods ourselves
class Man extends Human{
  override def Run(): Unit = {
    println("I'm running")
  }
  override def Swim(): Unit = {
    println("I'm swimming")
  }
  override def Walk(): Unit = {
    println("I'm walking")
  }
}

//Multiple inheritance, the Hybrid class inherits from Human and Animal
//Traits are the only way to implement multiple inheritance
class Hybrid extends Human with Animal{
  override def Howl(): Unit = {
    println("I'm a hybrid howling")
  }

  override def Sleep(): Unit = {
    println("I'm a hybrid sleeping")
  }

  override def Run(): Unit = {
    println("I'm a hybrid running")
  }

  override def Swim(): Unit = {
    println("I'm a hybrid swimming")
  }

  override def Walk(): Unit = {
    println("I'm a hybrid walking")
  }
}

object main extends App{
  var test:Human = new Man()
  test.Run()
  test.Swim()
  test.Walk()

  var test2:Hybrid = new Hybrid
  test2.Run()
  test2.Walk()
  test2.Swim()
  test2.Howl()
}
