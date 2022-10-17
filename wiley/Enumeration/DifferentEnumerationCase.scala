package com.wiley.Enumeration

object DifferentEnumerationCase extends App{

  object Donut extends Enumeration {
    type Donut = Value
    //There are 2 ways of declaring constants for your enumeration
    val Glazed, Chocolate, Strawberry = Value
    val Plain = Value("Plain")
    val Vanilla = Value("Vanilla")
  }

  println(s"Donut test: ${Donut.Glazed}")
  println(s"Donut ID test: ${Donut.Glazed.id}")

  println(s"All Donuts: ${Donut.values}")


  //For iteration
  Donut.values.foreach{
    case d if(d == Donut.Glazed || d == Donut.Vanilla) => println("We found "+d)
    case _ => println("This donut is not glazed or vanilla")
  }

}
