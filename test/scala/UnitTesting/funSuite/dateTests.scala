package UnitTesting.funSuite
import org.joda.time.DateTime
import org.scalatest.funsuite.AnyFunSuite

import java.util.Date

class dateTests extends AnyFunSuite{
  var JavaDate = new Date()
  var JodaDate = new DateTime()

  test("Checking current year"){
    assert(JavaDate.getYear+1900 === JodaDate.getYear)
  }

  test("Checking day of week"){
    assert(JavaDate.getDay === JodaDate.getDayOfWeek)
  }

  test("Testing month of year"){
    //We need to add one to Java date because it starts
    //From zero
    assert(JavaDate.getMonth+1 === JodaDate.getMonthOfYear)
  }
}
