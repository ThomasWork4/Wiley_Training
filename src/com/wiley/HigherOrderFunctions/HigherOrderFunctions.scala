package com.wiley.HigherOrderFunctions

object HigherOrderFunctions {
  def main(args: Array[String]): Unit = {
    //Higher order functions are functions that accept other
    //functions as a parameter input
    //Calling the first function and providing one Int
    //and one function
    functionName(25, Multiplication)
    var newList = List(25000.00, 50000.00, 100000.00)
    //println(smallPromotion(newList))
    println(greatPromotion(newList))
  }

  // This function applies the function provided as parameter b
  // to parameter a
  def functionName(a:Int, b:Int=>AnyVal):Unit = {
    println(b(a))
  }

  //self explanatory
  def Multiplication(a:Int):Int = {
    a*2
  }


  def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)
}
