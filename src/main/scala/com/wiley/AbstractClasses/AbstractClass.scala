package com.wiley.AbstractClasses

//An abstract class is a class that cannot be instantiated
//It can contain abstract methods or normal methods
//It can only be instantiated by inheriting with a normal class
//And then defining the methods yourself
//It's good to use when you don't know all the functionality of the class
//you are making, you can implement the parts you do know, and leave the parts
//you don't bodiless, ready for those who do know, to fill out the functionality
//for you in extended classes
abstract class Animal{
  def run(){}

  def die(): Unit ={
    println("I'm dead")
  }

}

class Dog extends Animal {
  override def run(): Unit ={
    println("I'm running")
  }
}

object newMain extends App {
var obj1 = new Dog
obj1.run()
}
