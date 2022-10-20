import org.scalatest.funsuite.AnyFunSuite
import com.wiley.Package.{PackageTrial, PracticePackage}

class PackageTesting extends AnyFunSuite{

  test("Testing a"){
    assert(PracticePackage.a === 200)
  }

  test("Add test"){
    assert(PracticePackage.add(2,5) === 7)
  }



}
