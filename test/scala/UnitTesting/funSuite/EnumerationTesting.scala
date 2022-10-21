package UnitTesting.funSuite

import com.wiley.Enumeration.EnumerationPractice.isPlanet
import org.scalatest.funsuite.AnyFunSuite

class EnumerationTesting extends AnyFunSuite{

  test("IsPlanetFunction") {
    assert(isPlanet("Earth") === true)
    assert(isPlanet("Random") === false)
  }
}
