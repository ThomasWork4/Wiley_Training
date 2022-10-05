package com.wiley.HigherOrderFunctions

object VariableLengthParameters {
  def main(args: Array[String]): Unit = {

    // for variable length parameter input
    var sum_of_numbers = add(1,2,3,4)
    println(sum_of_numbers)

    // for lists
    var List_of_Numbers = List(1,2,3,4)
    var result = addList(List_of_Numbers)
    println(result)

    // for maps
    val Map_to_use = Map(
      'a' -> 1,
      'b' -> 2,
      'c' -> 3,
      'd' -> 4
    )
    var result2 = addMap(Map_to_use)
    println(result2)
  }

  // This function accepts multiple parameters of type Int
  // This is similar to using a list without the need to
  // implicitly create the list in the first place
  // * symbol means, accept all possible Int parameters
  // The for loop iterates the list of numbers in the form of
  // a wrapped array
  // NOTE that args is just a random variable name, you can change it as you please
  def add(args: Int*): Int = {
    var sum = 0
    for(a<- args){
      sum+= a
    }
    sum
  }

  // The same as before except using a list instead of variable length parameters
  def addList(NumberList: List[Int]): Int = {
    var sum = 0
    NumberList.foreach {
      (element: Int) => sum+= element
    }
    sum
  }

  // The same as before except using a map instead of variable length parameters
  def addMap(map_to_use: Map[Char, Int]): Int = {
    var sum = 0
    for ((key, value) <- map_to_use) {
      sum += value
    }
    sum
  }


}
