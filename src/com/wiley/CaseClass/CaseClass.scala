package com.wiley.CaseClass

//syntax
//case class CaseClassName(Parameters)
//Case classes are good for modelling immutable data
//Case classes work really well with pattern matching

//Parent trait for the case classes
//It's basically a parent class from which you extend child classes
trait Car

//Case classes and objects that are children of the trait each with
// their own attributes
//By default, all constructor parameters are public and immutable
case class Volkswagen(ModelName:String, Age:Int) extends Car
case class BMW(Age:Int) extends Car
case object Tesla extends Car

//Call the callCase function and instantiate the Case classes / objects with their attributes
object MainCaseClass extends App{
  callCase(Volkswagen("Golf",2015))
  callCase(BMW(2018))
  callCase(Tesla)

  //Function takes an child class of the trait Car as an arugment
  //This can be any of our three example
  //Then we can use simple pattern matching to find which case class was entered into the function
  //and then print it's contents
  def callCase(f:Car) = f match{
    case Volkswagen(f, g)=>println("a="+f+" "+"b="+g)
    case BMW(f)=>println("a= "+f)
    case Tesla => println("No Argument")
  }
}


