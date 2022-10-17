package com.wiley.LabWork

import scala.collection.mutable.ListBuffer


object ListOfValues extends App{
  //First way
  val Storage2 = List.range(100, 150)
  print(Storage2)


  //Second way
  var Storage = new ListBuffer[Int]()
  for(i<-100 to 150){
    Storage += i
  }
  println(Storage)


}
