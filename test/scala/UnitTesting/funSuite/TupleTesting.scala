package UnitTesting.funSuite

import com.wiley.scalacohort.Tuples.Tuples.{tuple, tuple3}
import org.scalatest.funsuite.AnyFunSuite

class TupleTesting extends AnyFunSuite{

  test("Type check"){
    assert(tuple3._2.isInstanceOf[Int] === true)
  }

  test("Tuple contains test"){
    assert(tuple3._1 === "Thomas")
  }

  test("To string test"){
    assert(tuple3._2.toString === "22")
  }

  test("Size check"){
    assert(tuple3.productArity === 3)
  }

  test("Iteration test"){
    tuple.productIterator.foreach{i=>assert(i.isInstanceOf[Int] === true)}
  }
}
