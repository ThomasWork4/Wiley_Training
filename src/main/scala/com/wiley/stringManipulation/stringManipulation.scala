package com.wiley.stringManipulation

class stringManipulation {
  var s1 = "This is a string"
  //s2 and s3 are the same, just written differently
  var s2 = "Hello world"
  var s3 = "Hello"+" world"

  def show():Unit = {
    //This should print false
    println(s1.equals(s2))
    //This should print true
    println(s2.equals(s3))
    //Another way of writing
    //println(s1==s2)
    //println(s2==s3)
  }

}

object anothermain extends App {
  var test = new stringManipulation
  test.show()
}
