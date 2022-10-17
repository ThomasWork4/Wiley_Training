package com.wiley.ObjectOrientation

// Class
// The class name should always be the same as the file name
// This class is initialized with default values
//////////////////---------------------------------------////// This is the class constructor
class StudentClass(var id:Int = 0, var name:String = null) {
  def IncreaseID(): Unit = {
    id += 1
  }
  def setName(Entry:String): Unit = {
    name = Entry
  }
}

//Making an object the same way we do in all the rest of our programs
//Here we instantiate an an object with the default values from the class StudentClass
//This object is called s, it has an id and a name.

object ExecuteClass {
  def main(args: Array[String]): Unit = {
    //Creating our student object with default values set by the c
    var s = new StudentClass()
    println(s.id + " " + s.name)
    s.IncreaseID()
    println(s.id + " " + s.name)
    s.setName("Thomas")
    println(s"The student name is now "+s.name)
  }
}
