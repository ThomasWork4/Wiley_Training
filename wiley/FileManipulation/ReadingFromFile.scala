package com.wiley.FileManipulation
import scala.io.Source

object ReadingFromFile extends App{
  var File = Source.fromFile("C:\\Users\\thoma\\Desktop\\Training\\Training_Scala\\Scala_1\\FirstSBTProject\\src\\main\\scala\\com\\wiley\\FileManipulation\\Demo")

  //To print everything inside the file
  //println(File.mkString(""))

  //Iterating over each kine
  //File.getLines().foreach(z => println(z))

  //To print up to a certain amount of lines
  //File.getLines().take(2).foreach(println)

  //To get a certain index of lines
  //File.getLines().slice(0,1).foreach(println)

  //Convert to list or Array
  //var FileList = File.toList
  //println(FileList)
  var FileList = File.toArray
  println(FileList.mkString("Array(", ", ", ")"))





}
