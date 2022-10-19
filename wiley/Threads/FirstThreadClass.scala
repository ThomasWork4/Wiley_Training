package com.wiley.Threads



class FirstThreadClass extends Thread {

  override def run(): Unit = {
    println("Do parallel computation here "+Thread.currentThread().getName)
    Thread.sleep(2000)
    println("After thread sleep"+Thread.currentThread().getName)
  }
}

object  mainThread extends App {
  var thread1 = new FirstThreadClass()
  thread1.start()

  var thread2 = new FirstThreadClass()
  thread2.start()

  var thread3 = new FirstThreadClass()
  thread3.start()

}
