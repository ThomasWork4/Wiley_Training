package com.wiley.ScalaBreak

import scala.util.control.Breaks.break

object ScalaBreak extends App{
for(i<- 1 to 10 by 2){
  if(i==7){
    println(i)
    break
  }
}
}
