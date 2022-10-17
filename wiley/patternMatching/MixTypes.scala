package com.wiley.patternMatching

object MixTypes{
  def main(args:Array[String]):Unit = {
    // You don't need to print anything here because the function
    // prints your output for you
   var Result = search("two")
  }

  //Same as pattern matching script however we use the generic Any
  //which allows us to interpret multiple data types
  //I'm not sure for what reason we put the number but we
  // don't need them
  def search(a:Any):Any=a match {
    case 1 => println("Int"); 1
    case "two" => println("String");2
    case true => println("Boolean");3
    case false => println("Boolean");4
    case "a" => println("Char");5
    case 5.67 => println("Float");6
    case _ => println("None");7
    }
}
