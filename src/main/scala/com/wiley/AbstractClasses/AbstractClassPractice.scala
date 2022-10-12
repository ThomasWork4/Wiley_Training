package com.wiley.AbstractClasses

abstract class Human(var legs:Int = 2, var arms:Int = 2){
  //abstract method
  def run(){}

  def Swim(): Unit ={
    println("I'm swimming")
  }

  //abstract method
  def showAttributes(){}

}

class Man(legs:Int, arms:Int) extends Human(legs, arms){
  //Here we change the value of legs to 1, just to show that we can change it
  //This child class of the abstract class is where we define the
  //abstract methods
  override def run(): Unit ={
    println("I'm running")
  }

  override def showAttributes():Unit = {
    println("Number of legs: "+legs+" Number of arms: "+arms)
  }
}

object abstractmain extends App {
  var Me = new Man(2, 2)
  Me.run()
  Me.Swim()
  Me.showAttributes()
}

