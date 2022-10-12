package com.wiley.LabWork

object testing extends App {
  var nums = Array[Any](1,1,2) // Input array
  var tupleValues = removeDuplicates(nums)
  var k:Int = tupleValues._1
  var expectedNums:Array[Any] = tupleValues._2
  //assert(k == expectedNums.length)
  for (i<-0 until k){
    assert(nums(i) == expectedNums(i))
  }
  println(expectedNums.mkString("Array(", ", ", ")"))

  def removeDuplicates(ints: Array[Any]):(Int, Array[Any]) ={

    //Remove duplicate numbers
    var k:Int = 0
    for (i<-ints.indices){
      var Current_Number = ints(i)
      if(Current_Number != 0){
        for (j <- i+1 until ints.length) {
          if (ints(j) == Current_Number) {
            ints(j) = "_"
          }
        }
        k += 1
      }
    }

    //For pushing zeros to the end of an array
    var count = 0
    for(i <- ints.indices){
      if(ints(i) != "_"){
        ints(count) = ints(i)
        count += 1
      }
    }
    while(count < ints.length){
      ints(count) = "_"
      count += 1
    }

    //Return both required variables
    (k, ints)

  }
}