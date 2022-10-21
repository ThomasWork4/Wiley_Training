package UnitTesting.Tagging

import org.scalatest.Tag
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.tagobjects.Slow

object Super extends Tag("test")

class Tagging extends AnyFlatSpec{

  "The scala languauge" must "add correctly syntax" taggedAs(Slow) in {
    val sum = 1+1
    assert(sum === 2)
  }
  it must "Subtract correctly" taggedAs(Slow, Super) in {
    val diff=4-1
    assert(diff === 3)
  }
}
