package com.wiley.LabWork

object CustomSettings extends App{
  println("Please enter your name: ")
  var name = scala.io.StdIn.readLine()
  println("Please enter your age: ")
  var age = scala.io.StdIn.readInt()

  printf("Name: %s\nAge: %d",name,age)

}
