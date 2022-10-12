package com.wiley.finalKeyword

//Final variables - Cannot be overriden in child classes
//Final method - cannot be overriden in child classes
//Final class - cannot be inherited or extended by any class


//Final can be used on a class to make it un-extendable as well.
final class Animal {
  //Using the final keyword makes a variable completely immmutable
  //and you cannot override it
  final val NumberofLegs:Int=4

  //Note that the final keyword can be used for methods as well
  final def show():Unit = {
    println("I'm an animal")
  }
}

//UNCOMMENT BELOW
//class Ostrich extends Animal {
//  These do not work when final keyword is used
//  Whereas they both work in fieldOverriding where the final keyword is not used
//UNCOMMENT BELOW
//  override val NumberofLegs:Int = 2
//
//  override def show():Unit = {
//    println("I'm an Ostrich")
//  }
//}

//In conclusion
//var - Mutable
//val - Immutable but can be overriden (see example in fieldOverriding)
//final - Immutable and cannot be overriden (see above)
