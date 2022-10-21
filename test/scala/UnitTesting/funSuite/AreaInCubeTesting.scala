package UnitTesting.funSuite

import com.wiley.Testing.Testing
import org.scalatest.funsuite.AnyFunSuite

//NOTE - the object you are testing, must not extend App, otherwise
//the variables with not save
class AreaInCubeTesting extends AnyFunSuite{
  test("Testing.AreaInCube"){
    assert(Testing.AreaInCube(3) == 27)
  }
}
