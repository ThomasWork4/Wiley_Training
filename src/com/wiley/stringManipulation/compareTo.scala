package com.wiley.stringManipulation

class compareTo {
  var s1 = "This"
  //In this example, compareTo compares each letter one by one
  //They are all the same except for the last, o and n
  //n's unicode value is one less than o's unicode value
  //because it's one less in the alphabet
  //Therefore the result printed should be one
  var s2 = "Hello"
  var s3 = "Helln"

  def show():Unit = {
    //The compare to method goes through each letter of 2 strings,
    //and compares the unicode values of each character at each index
    //NOTE, off the bat
    //If the first string is shorter than the second  string
    //It will return a negative number
    //If the first string is bigger than the second string
    //It will return a positive number
    //If the first string is the same as the second string
    //It will return a 0

    //between two strings
    println(s1.compareTo(s2))
    println(s2.compareTo(s3))
  }

}

object main extends App {
  var test = new compareTo
  test.show()
}
