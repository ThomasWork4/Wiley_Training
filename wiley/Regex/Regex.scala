package com.wiley.Regex

object Regex extends App {

  val str = "Hello to all".r

  val source ="Hello to all from this world, Hello to all"

  //Find an instance of str inside source
  println(str.findFirstIn(source).getOrElse("Nothing found"))

  str.findAllIn(source).foreach(x=>println(x))

  str.findAllMatchIn(source).foreach(x=>println(x))

  //Seems to a be a way of indexing a string
  println(str.regex(4))

  val needsChange = "ReplaceTest"
  //Find an instance of the words and replace it with something
  val finalstr = "ReplaceTest".replaceAll(".Test", "**")
  val finalstr2 = "ReplaceTestTest".replaceFirst(".Test", "**")

  println(needsChange)
  println(finalstr)
  println(finalstr2)


  val strcheck = "Check"
  //Test if the words ends with a K, returns a boolean
  val finaltempstr = strcheck.matches(".*k")
  println(finaltempstr)

  val sstr ="Something to test the result"

  //The limit in this example stipulates how many times we allow the split to happen
  //If there are multiple instances of ng
  //The limit is 4 here but it only needs to be 1, because there is only 1 instance of ng in the string
  val finalStr=sstr.split(".ng", 4)
  println(finalStr.mkString("Array(", ", ", ")"))

}
