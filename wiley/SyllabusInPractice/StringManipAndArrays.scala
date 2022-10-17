package com.wiley.SyllabusInPractice

class StringManipAndArrays {
  var arr = Array(Array("Hel","Th","Comp"),Array("Jin", "Comp", "Marc"))
  var arr2 = Array(Array("lo","omas","uter"), Array("esh", "uter", "elo"))
  var arr3 = Array.ofDim[String](2, 3)

  def show(): Unit = {
    //How to print the contents of the matrix (MD array)
    for (i <- arr.indices) {
      for (j <- arr(i).indices) {
        print(arr(i)(j) + " ")
      }
      //I've put this here to separate by row, to make the printed results
      //Easier to visualize
      println("")
    }
  }

  def addArraysAndShow(): Unit = {
    for (i <- arr.indices) {
      for (j <- arr(i).indices) {
        arr3(i)(j) = arr(i)(j).concat(arr2(i)(j))
        print(" " + arr3(i)(j))
      }
      println()
    }
  }

  def same(value1:String, value2:String): Unit = {
    if(value1.equals(value2)){
      println("These are the same")
    }
    else{
      println("These are not the same")
    }
  }

  def unicodeDifference(value1:String, value2:String):Unit = {
    if(value1.compareTo(value2) == 0){
      println("These are the same")
    }
    else if(value1.compareTo(value2) < 0){
      println("Value 2 is lexographically less than Value 1")
    }
    else{
      println("Value 2 is lexicographically more than Value 1")
    }
  }

}

object Anothermain extends App{
  var test = new StringManipAndArrays
  test.addArraysAndShow()
  test.same(test.arr3(0)(2), test.arr3(1)(1))
  test.unicodeDifference(test.arr3(0)(1), test.arr3(1)(1))
}
