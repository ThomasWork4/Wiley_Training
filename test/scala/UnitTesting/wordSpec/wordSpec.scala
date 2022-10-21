package UnitTesting.wordSpec

import org.scalatest.wordspec.AnyWordSpec

class wordSpec extends AnyWordSpec{

  "A set" when{
    "empty" should {
      "have size 0" in {
        assert(Set.empty.size === 0)
      }
    }
    "produce NoSuchElementException when head is invoked " in{
      assertThrows[NoSuchElementException]{
        Set.empty.head
      }
    }
  }
}