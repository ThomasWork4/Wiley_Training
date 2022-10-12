package com.wiley.Constructors

//Parameterized constructor
class ParameterizedConstructor(i:Int, name:String) {
  def showStudent(): Unit = {
    println(i+" "+name)
  }

}

object practice2 extends App{
  var Me = new ParameterizedConstructor(1, "Thomas")
  Me.showStudent()
}
