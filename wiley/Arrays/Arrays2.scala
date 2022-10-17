package com.wiley.Arrays

class Arrays2 {
  var arr = new Array[Float](5)

  def show(): Unit = {
    //What does it print when nothing is in it
    //For integers, the default value is 0
    //For strings, the default value is null
    //For booleans, the default value false
    //For long, the default value is 0
    //For short, the default value is 0
    //for float, the default value is 0.0
    //For double, the default value is 0.0
    //For char, the default value is null character [/]
    println(arr.mkString("Array(", ", ", ")"))
  }

}

object Main extends App {
  var obj1 = new Arrays2
  obj1.show()
}
