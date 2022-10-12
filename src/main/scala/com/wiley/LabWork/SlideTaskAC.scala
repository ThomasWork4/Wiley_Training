package com.wiley.LabWork

abstract class Vehicle(val make:String=""){
}



case class Car(override val make:String) extends Vehicle
case class Bike(override val make:String) extends Vehicle


object vehicleReport{
  def printVehicles(Types:List[Vehicle]):Unit = {
    Types.foreach(x => println(x.make))
  }
}

object newMain extends App {
  var Bike1 = new Bike("Fire Storm Bike")
  var Bike2 = new Bike("BMW g310 R Bike")
  var Car1 = new Car("BMW 3 Series")
  var Car2 = new Car("VW Golf")
  var List_Of_Vehicles = List(Bike1, Bike2, Car1, Car2)
  vehicleReport.printVehicles(List_Of_Vehicles)
}
