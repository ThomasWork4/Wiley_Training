package com.wiley.Options


object myOwnTest extends  App {

  var person1 = new Human("Thomas","Blue")
  var person2 = new Human("David", "Brown")
  var person3 = new Human("Gerald","")
  var person4 = new Human("Leon", "Green")
  var person5 = new Human("Samuel","")
  var person6 = new Human("Blake","Grey")
  var Population = List(person1, person2, person3, person4, person5, person6)
  var eyeCheck = new EyeChecker()
  eyeCheck.unpack(Population)
}

class Human(var Name:String, var EyeColor:String) {}


class EyeChecker() {
  def unpack(Storage:List[Human]): Unit = {
    for(element <- Storage) {
      if (element.EyeColor == "Blue" || element.EyeColor == "Brown" || element.EyeColor == "Green" || element.EyeColor == "Grey") {
        printingStatus(Some(element))
      }
      else {
        printingStatus(None)
      }
    }
  }

  def printingStatus(person: Option[Human]): Unit = {
    person match {
      case Some(result) => println(person.get.Name+" has eye color: "+person.get.EyeColor)
      case None => println("No eye color specified")
    }
  }
}
