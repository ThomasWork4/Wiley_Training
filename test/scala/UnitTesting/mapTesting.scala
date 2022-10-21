package UnitTesting

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.ListBuffer


class mapTesting extends AnyFunSuite{
  var firstmap: Map[String, Int] = Map("Thomas" -> 22,
    "Jinesh" -> 36)

  test("Testing a key"){
    assert(firstmap("Thomas") === 22)
  }

  test("Removing an entry"){
    firstmap -= "Thomas"
    assert(firstmap.contains("Thomas") === false)
  }

  test("Adding an entry"){
    firstmap += "Thomas" -> 22
    assert(firstmap.contains("Thomas") === true)
  }

  test("Testing it's size"){
    assert(firstmap.size === 2)
  }

  def forLoopFunction(): ListBuffer[Boolean] = {
    var Storage:ListBuffer[Boolean] = ListBuffer()
    firstmap foreach {
      case (key, value) => if (value < 30) Storage += true
      else Storage += false
    }
    Storage
  }

  test("For loop test"){
    var Storage = forLoopFunction()
    assert(Storage.size === 2)
    assert(Storage.head === false)
    assert(Storage(1) === true)
  }


}
