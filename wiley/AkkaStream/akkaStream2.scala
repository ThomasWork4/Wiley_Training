package com.wiley.AkkaStream

import akka.actor.typed.ActorSystem
import akka.actor.typed.javadsl.Behaviors
import akka.stream.scaladsl.{Flow, Sink, Source}

import scala.concurrent.{ExecutionContext, Future}

object akkaStream2 {

  implicit val system = ActorSystem(Behaviors.empty, "ScalaCohort")
  implicit val ec: ExecutionContext = system.executionContext

  //Flow designed to execute with 4 concurrent threads
  val asyncFlow = Flow[Int].mapAsync(4) {
    x =>
      Future {
        x * 4
      }
  }


  val fastSource = Source(1 to 1000000).via(asyncFlow).map {
    x =>
      println(s"waiting on consumer ${x}")
      x
  }

  val slowSink = Sink.foreach[Int] {
    x =>
      Thread.sleep(1000)
      println(x)
  }

  def main(args: Array[String]): Unit = {
    fastSource.to(slowSink).run()
  }
}

