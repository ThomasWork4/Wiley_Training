package com.wiley.collections.Sets.HashSets

import scala.collection.immutable.HashSet
//As a note with regards to the collection hierarchy
/*          Traversable
                |
            Iterable
        --------|---------
        |       |        |
      Set       Map      Seq
 */
//Hash sets are really good for bulk making SQL statements
object HashSets extends App {
  //Start with Notepad ++

  //Either click at the start of the first line
  //Holt ALT SHIFT and move downwards till the end,
  //Then press Comma
  //OR
  //Go to Search -> Replace
  //First line put ^ - Meaning the first character of each line
  //Next line put whatever you want inserted (")
  //Change to regular expression at the bottom left


  //Then click replace all
  //Example of making bulk SQL statements
  //Do the same again but instead use $ - Meaning at the end of each line
  //And put (",) to be inserted
  var storage: HashSet[String] = HashSet("Thomas 500",
    "Charlotte 200",
    "Sam 6000",
    "Luke 1000")

  storage.foreach((element:String)=>{
    var Split_Line = element.split(" ")
    var line = "SELECT * FROM Employee WHERE Name='"+Split_Line(0)+"' AND Salary="+Split_Line(1)
    println(line)
  })



  //var hashSet = HashSet(23,1,2,3,4,5,6,10,15)
  //hashSet.foreach((element:Int) => println(element))
}
