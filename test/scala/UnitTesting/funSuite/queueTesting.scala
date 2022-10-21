package UnitTesting.funSuite

import com.wiley.collections.Queues.Queues.returnFirstElement
import org.scalatest.funsuite.AnyFunSuite

import scala.collection.immutable.Queue
import scala.util.Random

class queueTesting extends AnyFunSuite{

  private var newQueue = Queue(1,2,3,4,5)

  test("Testing front of queue"){
    assert(returnFirstElement(newQueue) === 1)
  }

  test("Testing dequeued element"){
    assert(newQueue.dequeue._1 === 1)
    assert(newQueue.dequeue._2 === Queue(2,3,4,5))
  }
  test("Testing a shuffled Queue"){
    assert(Random.shuffle(newQueue) !== newQueue)
  }
  test("Testing a sorted Queue"){
    assert(Random.shuffle(newQueue).sorted === newQueue)
  }


}
