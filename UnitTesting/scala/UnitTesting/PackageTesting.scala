package UnitTesting

import com.wiley.Package.PracticePackage
import org.scalatest.funsuite.AnyFunSuite

class PackageTesting extends AnyFunSuite{

  test("Testing a"){
    assert(PracticePackage.a === 200)
  }

  test("Add test"){
    assert(PracticePackage.add(2,5) === 7)
  }



}
