package com.wiley.AccessModifiers

class AccessModifiers {
  //This cannot be changed outside the class
  private var MostRestricted:Int = 10
  //Least restrictive - No access modifier
  var LeastRestrictive:Int = 20
  //Halfway between - Protected
  protected var Halfway:Int = 30

  //No Modifier / Public = Class(Yes), Companion(Yes), Subclass(Yes), Package(Yes), World(Yes)
  //^ Least restrictive

  //Protected = Class(Yes), Companion(Yes), Subclass(Yes), Package(No), World(No)
  //^ More restrictive than public, but less so that private

  //Private = Class(Yes), Companion(Yes), Subclass(No), Package(No), World(No)
  //^ Most restrictive

  def show(): Unit = {
    println(MostRestricted)
    println(LeastRestrictive)
    println(Halfway)
  }
}

object main extends App {
  var test = new AccessModifiers

}
