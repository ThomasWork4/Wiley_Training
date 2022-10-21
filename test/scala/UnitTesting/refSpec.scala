package UnitTesting

import org.scalatest.refspec.RefSpec

class refSpec extends RefSpec{
  object `A set`{
    object `when empty`{
      def `should have size 0`():Unit = {
        assert(Set.empty.size === 0)
      }
      def `should produce NoSuchElementException when head is invoked on an empty set`():Unit = {
        assertThrows[NoSuchElementException]{
          Set.empty.head
        }
      }
    }
  }
}
