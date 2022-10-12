package com.wiley.AnonymousObjects

import com.wiley.CustomClasses.CustomClasses

// Class with no attributes
// One method that sums the inputs and displays the sum
class AnonymousObjects {
  def add(a:Int,b:Int):Unit = {
    var add = a+b
    println("Sum="+add)
  }
}

object Main extends App{
  //Creating a new object but without a name
  //This is sometimes done for anonymity
  //It allows us to quickly utilize a method of a class
  //The main benefit is that you can declare and instantiate a new object in one line
  //Also, because you are not assigning a reference, it doesn't take up any space on the heap memory
  //and when the garbage collector runs, this will be one of the first objects to go
  new AnonymousObjects().add(10,10)
  new CustomClasses(10, "Sam").getRecord()


}
