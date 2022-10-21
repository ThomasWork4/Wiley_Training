package UnitTesting.funSuite

import com.wiley.Enumeration.DifferentEnumerationCase.Donut
import org.scalatest.funsuite.AnyFunSuite

class DonutEnumerationTesting extends AnyFunSuite{
  test("Testing a single Donut"){
    assert(Donut.Vanilla.id === 4)
  }
}
