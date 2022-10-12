package com.wiley.MultiDimensionalArrays

object StringInterpolation extends App{
  var test = new InterpolationExample
  test.show()


}


class InterpolationExample{
  var s1="Hello World"
  var version=2.12
  var test2 = true
  def show():Unit = {
    //How we can format strings and enter a double to 2 decimal places
    println(f"This is a string $s1%s\nScala version is $version%2.2f")
    println(f"This is a boolean \"$test2%b\"")
  }
}
