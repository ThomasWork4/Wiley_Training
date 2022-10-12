package com.wiley.MultiDimensionalArrays

object MultiDimensionalArrays extends App{
  var a = new TwoDimensionalArray
  a.show
  println("Another example")
  //Another example of how to create a 2D array, however I prefer the other
  //Option
  var Test = Array(Array(1,2,3),Array(3,2,1))
  //Changing / inserting a value
  Test(1)(1)=7
  //How to add to the end of the array
  Test ++= Array(Array(5, 6))
  for (i <- Test.indices) {
    for (j <- Test(i).indices) {
      print(Test(i)(j) + " ")
    }
    println("")
  }
}

//This doesn't need to be written inside a class,
//But just trying to get as much practice with classes
//as possible
class TwoDimensionalArray{
  // How to declare a multi dimensional array
  // The example below is 2 rows and 2 columns
  var arr = Array.ofDim[Int](10, 4)
  // Set a value inside the MD array
  arr(1)(0)=15
  // Print a value inside the MD array
  //println(arr(row#)(col#))

  def show():Unit = {
    //How to print the contents of the matrix (MD array)
    for(i<- arr.indices){
      for(j<- arr(i).indices){
        print(arr(i)(j)+" ")
      }
      //I've put this here to separate by row, to make the printed results
      //Easier to visualize
      println("")
    }
  }
}
