package UnitTesting

import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec


class featureSpec extends AnyFeatureSpec with GivenWhenThen{
  info("As a tv set owner")

  feature("UnitTesting.TV power button"){
    scenario("User presses the button when UnitTesting.TV is off"){
      Given("A UnitTesting.TV set is switched off")
      val tv = new TV
      assert(!tv.IsOn)

      When("Then power button is pressed")
      tv.pressPowerButton()

      Then("Really check UnitTesting.TV is on or not")
      assert(tv.IsOn)
    }
  }
}

class TV {
  private var on: Boolean = false
  def IsOn: Boolean = on
  def pressPowerButton(): Unit = {
    on = !on
  }
}