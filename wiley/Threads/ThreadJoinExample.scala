package com.training.learning.practise.jdbcconnectwithDB

class ThreadJoinExample extends Thread{
  override  def run(): Unit ={
    try{
      Thread.sleep(3000)
      println("Do parallel computation here"+Thread.currentThread().getName)
      Thread.sleep(2000)
      println("we are back "+Thread.currentThread().getName)
    }catch{
      case e:Exception=> e.printStackTrace()
    }

  }

}
object MainObject extends App {
  var t= new ThreadJoinExample()
  var t1= new ThreadJoinExample()
  var t2= new ThreadJoinExample()
  var t3= new ThreadJoinExample()


  t.start()
  //t.start()
  try{
    println("the current thread name is "+Thread.currentThread().getName)
    t.join()
  }catch{
    case e:Exception=> e.printStackTrace()
  }
  t1.start()
  try{
    println("the current thread name is "+Thread.currentThread().getName)
    t1.join()
  }catch{
    case e:Exception=> e.printStackTrace()
  }

  t2.start()
  try{
    println("the current thread name is "+Thread.currentThread().getName)
    t2.join()
  }catch{
    case e:Exception=> e.printStackTrace()
  }

  t3.start()




}