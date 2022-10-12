package com.wiley.LabWork

class Solution {
  def nextPermutation(nums: Array[Int]): Unit = {
    var i = nums.length - 2
    while ( {
      i >= 0 && nums(i + 1) <= nums(i)
    }) i -= 1
    if (i >= 0) {
      var j = nums.length - 1
      while ( {
        nums(j) <= nums(i)
      }) j -= 1
      swap(nums, i, j)
    }
    reverse(nums, i + 1)
    println(nums.mkString("Array(", ", ", ")"))
  }

  private def reverse(nums: Array[Int], start: Int): Unit = {
    var i = start
    var j = nums.length - 1
    while ( {
      i < j
    }) {
      swap(nums, i, j)
      i += 1
      j -= 1
    }
  }

  private def swap(nums: Array[Int], i: Int, j: Int): Unit = {
    val temp = nums(i)
    nums(i) = nums(j)
    nums(j) = temp
  }
}

object mainfourth extends App {
  var obj1 = new Solution
  var Storage = Array(3,2,1)
  obj1.nextPermutation(Storage)

}