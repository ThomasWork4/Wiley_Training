package com.wiley.Constructors

class ThisKeyword {
var id:Int = 0
  var name:String="No name submitted"

  //A different way of implementing a constructor
  //This is a basically a mixture between default and parameterized
  //This keyword is fairly important for making sure constructors are failsafe
  def this(id:Int,name:String){
    this()
    this.id=id
    this.name=name
  }

  def show():Unit = {
    println(id+" "+name)
  }
}

object testmethod extends App{
  //You have the option here to type a parameter or not
  //Slightly confusing because you also have the choice to parameterize or not
  //with a default constructor
  //This is just supplementary knowledge
  var test = new ThisKeyword()
  var test2 = new ThisKeyword(5, "Thomas")
  test.show()
  test2.show()
}
