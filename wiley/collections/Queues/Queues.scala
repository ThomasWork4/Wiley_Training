package com.wiley.collections.Queues

import scala.collection.immutable.Queue

//First in first out data structure
//Think of it like a real life queue
//The person at the front of the queue who joined first
//always gets served first
//Queues are good for processes in which you need to access the
//head element in O(1) time

object Queues extends App{
  var queue = Queue(1,2,3,4,5,6,"Hello")
  var second_queue = Queue(8,9,10,11,12,13,14,15)

  println(queue)
  println(second_queue)

  second_queue.foreach((element:Int)=> {
    print(element+4+" ")
  })

  println("")

  println(queue.front)

  println(queue.reverse)

  println(queue.enqueue(100))

  println(queue)

  //To dequeue the front of the queue
  //Without ._2, the dequeue saves the result as a tuple
  //where index 1 is the dequeued value
  //and index 2 is the resultant queue
  //in most cases it might only be useful to safe the dequeued queue
  //Which is why we have done what we've done below
  queue = queue.dequeue._2
  println(queue)

  //This isn't useful other than for testing
  //Otherwise you would just do queue.front
  //No need to write a function
  def returnFirstElement(queue:Queue[Int]):Int = queue.front
  println(returnFirstElement(second_queue))
}
