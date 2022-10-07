package com.wiley.SyllabusInPractice


trait Poodle {
  final val LegNumber:Int = 4
  val CurlyFur:Boolean = true

  def Run(){}

  def Walk(){}

}

trait CockerSpaniel {
  val StraightFur:Boolean = true

  def Eat(){}
}


class Cockapoo extends Poodle with CockerSpaniel {
  //This Cockapoo doesn't have curly fur
  override val CurlyFur:Boolean = false

  override def Eat():Unit = {
    println("Eating")
  }

  override def Run(): Unit = {
    println("Running")
  }

  override def Walk(): Unit = {
    println("Barking")
  }
}

//Singleton
object UnfortunateCockapoo {
  final val legNumber: Int = 3

  def Eat(): Unit = {
    println("Eating")
  }

  def Sleeping(): Unit = {
    println("Sleeping")
  }
}


object main extends App {
  println(giveBirth(0))

  //Recursive function
  def giveBirth(currentLitter: Int): Int = {
      if (currentLitter == 10) {
        10
      }
      else {
        var NewLitter = currentLitter + 1
        giveBirth(NewLitter)
      }
    }
}






