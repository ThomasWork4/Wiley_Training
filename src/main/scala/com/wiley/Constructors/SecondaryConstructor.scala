package com.wiley.Constructors

//Mixture between parameterized and default constructor
//The problem here is if we instantiate our class with three
//parameters, it will throw an error because currently it only accepts
//two entries
//To test this, remove the def this() function
//Note some of the code may not work, was playing around with this for a fair while
class SecondaryConstructor(id:Int, name:String) {
  //Extra default attribute
  //
var age:Int=0
var EyeColor:String="None submitted"
  var obj1:Object = null
  //This function acts as a secondary constructor that
  //accepts three values instead of just 2 and setting them accordingly
  //this is whats known as an auxiliary constructor OR secondary constructor
  def this(id:Int, name:String, age:Int, obj1:Object){
    this(id,name)
    this.age=age
    this.obj1=obj1
  }

  //This doesn't need to be here, this is just an example of constructor overloading
  //by adding an additional parameter to a different constructor in the same class
  def this(id:Int, name:String, age:Int, obj1:Object, EyeColor:String){
    this(id, name)
    this.age = age
    this.obj1 = obj1
    this.EyeColor = EyeColor
  }

  def showAttributes(): Unit = {
    println(id + " " + name + " " + age + " " + EyeColor + " ")
  }

  def showObjectPair(): Unit = {
    println(obj1.getClass)
  }

}


object main extends App {
  //Now we make an object and it should accept all three values, whereas
  //without the this function, it would only accept two
  var test = new SecondaryConstructor(1, "Thomas", 25,null,"Blue")
  var secondTest = new SecondaryConstructor(2, "Sam",22,test,"Brown")
  test.showAttributes()
  secondTest.showAttributes()
  secondTest.showObjectPair()

}