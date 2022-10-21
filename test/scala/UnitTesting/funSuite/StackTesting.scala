package UnitTesting.funSuite

import com.wiley.collections.Stacks.Stacks
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable

//NOTE - the object you are testing, must not extend App, otherwise
//the variables with be tested with null values



class StackTesting extends AnyFunSuite with BeforeAndAfter{

  before {
    var n:Int = 10
    //Before can be used when running multiple test cases where you don't want a particular
    //Variable to change
    //Everytime a new test case is run, any values involves that are defined inside this
    //before block, will revert to whatever they are originally
    //E.g. Without before n = 10 => def(ChangeN){n = 20} => returns n = 20
    //                    n = 20 => def(ChangeN){n == 10} => returns false
    //
    //E.g. With before n = 10 => def(ChangeN){n = 20} => returns n = 20
    //                 n Resets to 10 before the next test case
    //                 n = 10 => def(ChangeN){n == 10} => returns true
  }

  test("check the size before and after popping, and check the popped value "){
    assert(Stacks.oldSize == 2)
    assert(Stacks.newSize == 1)
    assert(Stacks.result == 2)
  }

  test("Catching exception when attempting to pop from an empty stack"){
    val emptyStack = new mutable.Stack[Int]
    intercept[NoSuchElementException]{
      emptyStack.pop()
    }
    assert(emptyStack.isEmpty)
  }

  test("Index out of bounds exception"){
    val s ="Hi"
    intercept[IndexOutOfBoundsException]{
      s.charAt(-1)
    }
  }

  test("Testing IndexOutOfBounds with message"){
    val s = "Hi"
    val thrown=intercept[IndexOutOfBoundsException]{
      s.charAt(-1)
    }
    assert(thrown.getMessage === "Index -1 out of bounds for length 2")
  }
}
