package com.wiley.LabWork

object VariableLabWork extends App{
print("{\n\"donut_name\":\"Vanilla Donut\",\n\"quantity_purchased\":\"10\",\n\"price\":2.5\n}")

  //Inputting strings and printing them
  println("What is your first name: ")
  var name = scala.io.StdIn.readLine()
  println("What is your age: ")
  var age = scala.io.StdIn.readInt()
  println("Your name is: " + name + "\nYour age is: " + age)

}
