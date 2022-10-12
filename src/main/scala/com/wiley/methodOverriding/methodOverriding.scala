package com.wiley.methodOverriding

//Method-overriding is where the parameter type and parameter number
//is the same for to same named methods
//but the body of the method is is different

object methodOverriding extends App{
  var obj1 = new Animal()
  var obj2 = new Amphibian()
  obj1.FirstMethod()
  obj2.FirstMethod()
}


class Animal(var NumberOfLegs:Int = 0, var AnimalName:String = "None"){
  def FirstMethod():Unit = {
    println("Method inside Animal Class")
  }
}

class Amphibian extends Animal(){
  override def FirstMethod(): Unit = {
    println("Method inside Amphibian Class")
    //If you want to access the parent class method, instead of the child class method
    // you can use the super keyword
    //super.FirstMethod()
    //NOTE it is possible to use the super keyword inside a grandchild class
    //the "superclass" of the granchild, is technically the child class
    //Meaning the method call would be from the child class
  }
}