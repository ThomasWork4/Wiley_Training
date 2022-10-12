package com.wiley.List

object BasicLists extends App {
  var listOfNumbers = List(1, 2, 3, 4, 5)

  //Three ways of iterating a list and printing the contents
  //I've used print in these examples to keep results on the same
  //line, but it might be an idea to use println in future to seperate
  //the elements
  // NOTE {} is for multi-line statements
  // () is for single line statements
  //As an example, the first two use () whereas the last is {}
  //because it's on multiple lines

  //#1
  listOfNumbers.foreach(print)

  //Just to break up the result of the above and before for loops
  println

  //#2
  listOfNumbers.foreach(print)

  //Just to break up the result of the above and before for loops
  println

  //#3 Probably the most useful because you can manipulate each
  //element if you want
  listOfNumbers.foreach{
    (element: Int) => print(element + " ")
  }

}
