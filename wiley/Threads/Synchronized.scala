package com.wiley.Threads
import org.joda.time.DateTime

object Synchronized{
  private var ctr=0L
  def getCtr=this.synchronized{
    ctr=ctr+1
    var dt = new DateTime();
    //There should be a very small (Millisecond) delay between threads executing
    //This method
    println(s"in block"+Thread.currentThread().getName+s" ${dt}")
    ctr
  }
  def bar={
    val currCt=getCtr
    currCt
  }
}
class TrialThread extends Thread{
  override  def run(): Unit ={
    this.synchronized {
      var dt = new DateTime();
      //When not using join - There should be no delay between these threads executing in parallel
      //When using join - There should be a very small delay between the threads executing this line
      //This is because forces certain threads to stop whilst the current one is executing, which is in turn
      //what creates these small delays
      println(s"Following thread is executing the code ${Synchronized.bar} and ${Thread.currentThread().getName} and ${dt}")
    }
  }
}
object Demotrial extends App{
  var t = new TrialThread()
  var t1 = new TrialThread()
  var t2 = new TrialThread()
  var t3 = new TrialThread()

  t.start()
  //t.start()
  try {
    t.join()
  } catch {
    case e: Exception => e.printStackTrace()
  }
  t1.start()
  try {
    t1.join()
  } catch {
    case e: Exception => e.printStackTrace()
  }
  t2.start()
  try {
    t2.join()
  } catch {
    case e: Exception => e.printStackTrace()
  }
  t3.start()
}