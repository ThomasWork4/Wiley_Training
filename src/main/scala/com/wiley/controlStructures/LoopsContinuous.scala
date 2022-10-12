package com.wiley.controlStructures

object LoopsContinuous extends App {
  var a = 10

  //Infinite loop
//  while(true){
//    println(a)
//    a=a+2
//  }

  //Same as a while loop, perform a certain action
  //until the termination criteria is met
  var Hello:String = "Hello"
  do{
    println(Hello)
    Hello += " Hello"
    a += 2
  }while(a<=20)
}
