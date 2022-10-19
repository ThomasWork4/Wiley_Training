package com.wiley.Threads

import java.util.Date

class DateThreadUsingSleep extends Thread{
  override def run():Unit = {
    try {
      while (true) {
        var d2 = new Date()
        print("\r " + d2)
        Thread.sleep(1000)
      }
    }
    catch{
      case e:Exception => println("Exception occurred")
    }
  }
}

//Make sure you use start to run threads parallel
//Anything inside the run() function will run automically as it's called by the start method
//Anything with a different function will run as usual and will need to be called

/*
Join method in Java allows one thread to wait until another
thread completes its execution. In simpler words, it means it waits
for the other thread to die. It has a void type and throws
InterruptedException. 
*/



object mainSleep extends App {
  var dateThread = new DateThreadUsingSleep
  dateThread.start()
}
