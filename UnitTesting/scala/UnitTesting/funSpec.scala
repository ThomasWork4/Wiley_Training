package UnitTesting

import org.scalatest.funspec.AnyFunSpec

class funSpec extends AnyFunSpec {

  describe("When empty") {
    it("Should have size 0") {
      assert(Set.empty.size === 0)
    }
  }

  it("Should produce NoSuchElementException when head is invoked on empty set") {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }
}

