package com.wiley.Functions

object ScalaFunctions {
  // To write functions, you need to have a main function
  // A great shortcut is to write main, and then click tab
  def main(args: Array[String]): Unit = {
    functionName()
    var resultOfFunction = anotherFunction()
    println(resultOfFunction)
    functionExample(5, 10)
  }

  def functionName(): Unit = {
    println("Simple function")
  }

  //If you don't stipulate the data type of the value being returned
  //It won't work properly
  //If i stipulate Any, it's fairly safe because it covers a lot of
  //data types
  //If you know what type you are returning, it's better to type that
  //Because any can sometimes be unsafe
  //If you don't stipulate anything at all, the function will set the return
  //type for you, but again, this might not be safe in some cases
  //NOTE the keyword return does exist, in this example we haven't used it
  //variable on it's own
  def anotherFunction():Int={
    var a=2
    a
  }

  //The return type here is Unit because we are not returning anything
  //just printing
  def functionExample(a:Int,b:Int): Unit ={
    var c=a+b
    println(c)
  }
}
