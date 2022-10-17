package com.wiley.MultiDimensionalArrays

class AdditionOfMDArrays {
  var FirstArray = Array(Array(1,2,3,4),Array(4,3,2,1))
  var SecondArray = Array(Array(10,11,12,13),Array(13,12,11,10))
  //Empty array to store the result of the above
  var ThirdArray=Array.ofDim[Int](2,4)

  def addArraysAndShow():Unit = {
    for(i <- FirstArray.indices){
      for(j <- FirstArray(i).indices){
        ThirdArray(i)(j)=FirstArray(i)(j)+SecondArray(i)(j)
        print(" "+ThirdArray(i)(j))
      }
      println()
    }
  }
}

object main extends App {
  var test = new AdditionOfMDArrays
  test.addArraysAndShow()
}
