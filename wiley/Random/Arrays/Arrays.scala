package com.wiley.Random.Arrays

object Arrays extends App{
  //One way to create an array
  var arr=Array(1,2,3,4,5,6,7)

  //Second way to create an array -- More useful for adding new elements
  var arr2= new Array[Int](20)
  //Adding to this array works because we have space
  arr2 :+ 1

  //Indexing an array
  //Print value at index 6
  println(arr(6))

  //printing the contents
  println(arr.mkString("Array(", ", ", ")"))

  //for loop
  for(a<-arr){
    print(a+ ",")
  }
  println("")

  //setting a value at an index value
  arr(4) = 67
  println(arr(4))







}
