import org.scalatest.flatspec.AnyFlatSpec

class flatSpec extends AnyFlatSpec {

  //flatSpec presents another way of defining unit tests.
  //Either you can create a test using "" should "" in {}
  //OR
  //it should "" in {}
  "An empty Set" should "have size 0" in {
    assert(Set.empty.size === 0)
  }


  it should "Throw an exception when trying to index an empty Set" in{
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }
}
