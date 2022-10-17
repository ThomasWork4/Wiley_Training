package com.wiley.HigherOrderFunctions

object Composition {
  def main(args: Array[String]): Unit = {

    //Composition is basically stacking functions
    //First the compiler executes add(2)
    //Then provides the output to multiplyby2()
    //In this example we are taking the add method from a different
    //object "SupplementaryObject"
    //If we need an object or method from another package,
    //We need to stipulate the name of the package as well before calling the method
    val result=multiplyby2((SupplementaryObject.add(2)))
    //add(2) --> multiplyby2(add)
    println(result)
  }

  def multiplyby2(a:Int):Int = {
    a*2
  }

}
