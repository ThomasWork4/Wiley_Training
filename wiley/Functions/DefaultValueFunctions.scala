package com.wiley.Functions

object DefaultValueFunctions {
  def main(args: Array[String]): Unit = {
    //print(DefaultValueFunction())
    //The function below sets a to 4 and b to 0
    //print(DefaultValueFunction(4))
    //The function below sets a to 0 abd b to 4
    //print(DefaultValueFunction(b=4))
    print(DefaultValueFunction(10, 20))

  }


  // This function will has default values in the case that there is no
  // user input values for a or b.
  // If this is the case the function will automatically set a or b to 0
  // depending on which values are missing
  def DefaultValueFunction(a:Int=0, b: Int=0):Int = {
    a + b
  }
}
