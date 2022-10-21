package UnitTesting.freeSpec

import org.scalatest.freespec.AnyFreeSpec

class freeSpec extends AnyFreeSpec{

  "A set " -{
    "When empty" -{
      "Should have size 0"-{
        assert(Set.empty.size === 0)
      }
    }
  }

  "Should produce NoSuchElementException" -{
    assertThrows[NoSuchElementException]{
      Set.empty.head
    }
  }
}
