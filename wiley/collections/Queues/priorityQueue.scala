package com.wiley.collections.Queues

import scala.collection.mutable

object priorityQueue extends App{

  case class Donut(name:String, price:Double)

  def donutOrder(d:Donut) = d.price

  val priorityQueue:mutable.PriorityQueue[Donut] = mutable.PriorityQueue(
    Donut("Plain",1.50),Donut("Chocolate", 2.00), Donut("Strawberry", 4.00))(Ordering.by(donutOrder))

  println(priorityQueue)

  priorityQueue.enqueue(Donut("Glazed", 10.00))
  println(priorityQueue)

  priorityQueue.dequeue()
  println(priorityQueue)

  priorityQueue.dequeue()
  println(priorityQueue)

  priorityQueue.enqueue(Donut("Mint", 0.5))
  println(priorityQueue)

  priorityQueue.dequeue()
  println(priorityQueue)
}
