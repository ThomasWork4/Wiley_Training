package com.wiley.fieldOverriding

class Animal(val NumberofLegs:Int = 0){
  def show():Unit = {
    //Currently our immutable NumberofLegs field is defaulted to 0
    println(NumberofLegs)
  }
}

class Dog extends Animal{
  //This only works if the parent class attribute is val??
  //You can only override the original value, if the value is immutable?
  //Random concept, but it works
  //This is very useful for implementing specific instances of
  //inherited fields
  //Just to reiterate, this concept will not work with var fields
  override val NumberofLegs:Int = 4
}

object maintest extends App{
  var obj1 = new Dog
  var obj2 = new Animal
  obj1.show()
  obj2.show()
}




