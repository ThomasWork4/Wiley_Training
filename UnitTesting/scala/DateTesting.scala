import org.scalatest.funsuite.AnyFunSuite
import com.wiley.Dates
import com.wiley.Dates.Dates.{d2, dt, dt2}
import org.joda.time.DateTime

class DateTesting extends AnyFunSuite {

  test("Current day") {
    assert(d2.getDay === 2)
  }

  test("Current month") {
    assert(d2.getMonth === 9)
  }

  test("Joda vs Default") {
    assert(d2.getDay === dt.getDayOfWeek)
  }

  test("Add custom time") {
    var dt2 = new DateTime(2022, 3, 26, 12, 0, 0, 0);
    dt2 = dt2.plusHours(2)
    assert(dt2.getHourOfDay == 14)
  }

  test("Remove custome time"){
    var dt2 = new DateTime(2022, 3, 26, 12, 0, 0, 0);
    dt2 = dt2.minusMonths(2)
    assert(dt2.getMonthOfYear == 1)
  }

}


