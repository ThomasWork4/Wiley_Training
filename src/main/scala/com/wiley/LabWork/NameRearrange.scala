package com.wiley.LabWork

//Very elegent solution taken from GeeksforGeeks
//https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/
//Has been rewritten in scala

object NameRearrange {
  def printPermutn(str: String, ans: String): Unit = {
    if (str.isEmpty) {
      System.out.print(ans + " ")
      return
    }
    //ch = T
    //ros = T + homas

    for (i <- 0 until str.length) {
      val ch = str.charAt(i)
      val ros = str.substring(0, i) + str.substring(i + 1)
      printPermutn(ros, ans + ch)
    }
  }

  def main(args: Array[String]): Unit = {
    val s = "Thomas"
    printPermutn(s, "")
  }
}