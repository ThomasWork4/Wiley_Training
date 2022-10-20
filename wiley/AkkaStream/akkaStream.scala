package com.wiley.AkkaStream

import akka.actor.typed._
import akka.actor.typed.javadsl.Behaviors
import akka.stream.scaladsl.{Flow, Sink, Source}
import org.joda.time.DateTime

import scala.concurrent.{ExecutionContext, Future}


object akkaStream{
  //Actor system is group of threads that executes in the backend
  implicit val system = ActorSystem(Behaviors.empty, "ScalaCohort")
  //This line has been added so that we can execute the below with multiple threads
  implicit val ec:ExecutionContext=system.executionContext
  //Source of the "water flow"
  val source = Source(1 to 1000000000)
  //How the "water" is filtered or transformed
  val flow = Flow[Int].map(x => x * 4)
  //How the "water" is presented
  val sink = Sink.foreach[Int](x => print(""))
  //Now all we need to do is connect the source, flow and sink
  //This is done using a single thread from the ActorSystem thread network
  val firstGraph = source.via(flow).to(sink)

  //We've added this line so that we can execute our flow section, which might take some time
  //Over 4 threads instead of just 1
  val asyncFlow = Flow[Int].mapAsync(4){
    x => Future{
        x*4
      }

  }

  def main(args: Array[String]): Unit = {
    println("Welcome to akka world")
    //firstGraph runs in contention with the Actor system thread
    //Therefore can be executed using it's run method
    var dt = new DateTime();
    println(dt)
    source.via(asyncFlow).to(sink).run()
    //firstGraph.run()
    var dt2 = new DateTime();
    println(dt2)
  }
}

