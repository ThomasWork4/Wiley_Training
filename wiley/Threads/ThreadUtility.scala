package com.wiley.Threads

/*
Daemon thread in Java is a low-priority thread that runs in
the background to perform tasks such as garbage collection.
Daemon thread in Java is also a service provider thread that
provides services to the user thread.
*/

class ThreadUtility extends Thread{
  override def run():Unit = {
   if(Thread.currentThread().isDaemon){
   println("Daemon Thread")
   }
    else{
     println("Other thread")
   }
  }
}

object mainUtility extends App{
  var a = new ThreadUtility
  var b = new ThreadUtility
  var c = new ThreadUtility
  a.setDaemon(true)

  a.start()
  b.start()
  c.start()
}
