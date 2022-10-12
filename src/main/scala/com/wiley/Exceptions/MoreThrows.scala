package com.wiley.Exceptions

class MoreThrows{
  @throws(classOf[IndexOutOfBoundsException])
  def validate(): Int = {
    var Storage = List(1,2)
    Storage(5)
  }
}

object mainagain extends App {
  var e = new MoreThrows()
  try{
    e.validate()
  }
  catch{
    case ex:IndexOutOfBoundsException => println("IndexOutOfBoundsException")
  }
  println("Rest of code")

}

